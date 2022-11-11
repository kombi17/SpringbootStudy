package com.ishift.bootStudy.board.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ishift.bootStudy.board.model.vo.BoardDetail;
import com.ishift.bootStudy.board.model.vo.BoardList;
import com.ishift.bootStudy.board.service.BoardServiceImpl;
import com.ishift.bootStudy.service.MemberServiceImpl;
import lombok.RequiredArgsConstructor;

// @RestController : @Controller + @ResponseBody
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  @Autowired
  BoardServiceImpl boardService;

  @Autowired
  MemberServiceImpl memberService;


  @GetMapping("/boardList")
  public String boardList() {
    return "board/boardList";
  }

  @ResponseBody
  @GetMapping("/selectBoardList")
  public List<BoardList> selectBoardList(@RequestParam Map<String, Object> paramMap) {

    List<BoardList> boardList = new ArrayList<BoardList>();

    boardList = boardService.selectBoardList(paramMap);


    return boardList;
  }

  @GetMapping("/boardDetail/{boardNo}")
  public String boardDetail(@PathVariable("boardNo") String boardNo, Principal principal,
      Model model, HttpServletRequest req, HttpServletResponse resp) {

    // principal 객체를 통해 로그인 한 회원의 아이디 조회 후 jsp로 전달(수정, 삭제 버튼 노출 여부 결정)
    String userId = principal.getName();

    // boardDetail 조회 service
    BoardDetail detail = boardService.selectBoardDetail(boardNo);

    // 글 쓴 사람의 userNo
    int writerNo = detail.getUserNo();

    // 로그인 한 사람의 userNo
    int loginUserNo = memberService.selectLoginUser(principal.getName()).getUserNo();

    if (detail != null) {
      // 상세 조회에 성공한 경우
      if (writerNo != loginUserNo) {
        // 조회수 증가
        Cookie cookie = null; // 기존에 존재하던 쿠키를 저장하는 변수
        Cookie[] cArr = req.getCookies(); // 쿠키 얻어오기

        if (cArr != null && cArr.length > 0) {
          // 얻어 온 쿠키가 있을 경우
          for (Cookie c : cArr) {
            if (c.getName().equals("readBoardNo")) {
              cookie = c;
            }
          }
        }

        int result = 0;

        if (cookie == null) {
          // 기존에 "readBoardNo" 라는 이름의 쿠키가 없던 경우
          // readBoardNo라는 이름으로 쿠키에 boardNo를 세팅해준다
          cookie = new Cookie("readBoardNo", boardNo + "");

          // 조회수 증가 서비스 호출
          result = boardService.updateReadCount(boardNo);
        } else {
          // 기존에 readBoardNo라는 쿠키가 있는 경우
          // 쿠키에 저장된 값 뒤에 현재 조회된 게시글 번호를 추가하여 조회수 중복 증가를 막는다
          // 단, 기존 쿠키값에 중복되는 번호가 없어야 함
          String[] temp = cookie.getValue().split("/"); // 기존 값
          // ex) "readBoardNo" : "1/2/3/4/5"

          List<String> list = Arrays.asList(temp); // 배열을 List로 변환

          // String.indexOf("문자열") : String에서 "문자열"과 일치하는 부분이 있으면
          // 일치하는 부분의 시작 인덱스 반환
          // 없으면 -1 반환

          // List.indexOf(Object) : List에서 Object와 일치하는 부분의 인덱스 반환
          // 일치하는 부분이 없으면 -1 반환
          if (list.indexOf(boardNo + "") == -1) {
            // list로 변환된 조회된 게시글 번호를 확인 (기존 쿠키값에 중복되는 번호를 확인하기 위해)
            cookie.setValue(cookie.getValue() + "/" + boardNo);
            result = boardService.updateReadCount(boardNo);
          }
        }

        if (result > 0) {
          detail.setReadCount(detail.getReadCount()); // 이미 조회된 데이터 DB와 동기화

          // 조회 증가 성공 시 게시글 번호 추적
          cookie.setPath(req.getContextPath());
          cookie.setMaxAge(60 * 60 * 1); // 1시간
          resp.addCookie(cookie);
        }
      }
    }

    model.addAttribute("userId", userId);
    model.addAttribute("detail", detail);

    return "board/boardDetail";

  }

  @GetMapping("/boardWriteForm")
  public String boardWriteForm(
                              @RequestParam String mode, 
                              @RequestParam(required=false) String boardNo,
                              Model model) {

    if (mode.equals("update")) {
      // 게시글 수정일 경우 detail 조회해서 화면에 보여줘야 함
      BoardDetail detail = boardService.selectBoardDetail(boardNo);

      model.addAttribute("detail", detail);
    }

    model.addAttribute("mode", mode);
    return "board/boardWriteForm";
  }

  @PostMapping("/boardWrite")
  public String boardWrite(
                          @RequestParam Map<String, Object> paramMap,
                          String mode,
                          Principal principal,
                          RedirectAttributes ra) {

    int userNo = memberService.selectLoginUser(principal.getName()).getUserNo();

    paramMap.put("userNo", userNo);

    // 제목, 내용 받아서 DB에 저장, 이미지도 저장...
    int result = 0;
    try {

      if(mode.equals("insert")) { // 수정 X
        result = boardService.insertBoard(paramMap);
        if (result > 0) {
          ra.addFlashAttribute("message", "게시글이 작성되었습니다.");
        } else {
          ra.addFlashAttribute("message", "게시글 작성 실패");
        }
        
      } else {
        // 수정일 때
        result = boardService.updateBoard(paramMap);
        
        if(result > 0) {
          ra.addFlashAttribute("message", "게시글이 수정되었습니다.");
        } else {
          ra.addFlashAttribute("message", "게시글 수정 실패");
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/board/boardList";
  }


  @GetMapping("/boardDelete/{boardNo}")
  public String boardDelete(@PathVariable("boardNo") String boardNo, RedirectAttributes ra) {

    int result = boardService.deleteBoardDetail(boardNo);

    String msg = null;
    String path = null;

    if (result > 0) {
      msg = "게시글 삭제 완료";
      path = "redirect:/board/boardList";
    } else {
      msg = "게시글 삭제 실패";
      // 어디로 갈 것인가?
      path = "redirect:/board/boardDetail/" + boardNo;
    }

    ra.addFlashAttribute("message", msg);

    return path;
  }

}
