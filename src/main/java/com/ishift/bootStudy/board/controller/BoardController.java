package com.ishift.bootStudy.board.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
      Model model) {

    // principal 객체를 통해 로그인 한 회원의 아이디 조회 후 jsp로 전달(수정, 삭제 버튼 노출 여부 결정)
    String userId = principal.getName();

    // boardDetail 조회 service
    BoardDetail detail = boardService.selectBoardDetail(boardNo);

    model.addAttribute("userId", userId);
    model.addAttribute("detail", detail);

    return "board/boardDetail";

  }

  @GetMapping("/boardWriteForm")
  public String boardWriteForm() {
    return "board/boardWriteForm";
  }

  @PostMapping("/boardWrite")
  public String boardWrite(@RequestParam Map<String, Object> paramMap, Principal principal,
      RedirectAttributes ra) {

    int userNo = memberService.selectLoginUser(principal.getName()).getUserNo();

    paramMap.put("userNo", userNo);

    // 제목, 내용 받아서 DB에 저장, 이미지도 저장...
    int boardNo = 0;
    try {

      boardNo = boardService.insertBoard(paramMap);

//      ra.addFlashAttribute("message", "게시글이 작성되었습니다.");
//      ra.addFlashAttribute("message", "게시글 작성 실패!");
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "board/boardDetail/" + boardNo;
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
      path = "board/boardDetail" + boardNo;
    }

    ra.addAttribute("message", msg);

    return path;
  }

}
