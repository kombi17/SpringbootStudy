package com.ishift.bootStudy.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ishift.bootStudy.board.model.vo.BoardList;
import com.ishift.bootStudy.board.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;

// @RestController : @Controller + @ResponseBody
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

  @Autowired
  BoardServiceImpl boardService;


  @GetMapping("/boardList")
  public String boardList() {
    return "board/boardList";
  }

  @ResponseBody
  @GetMapping("/selectBoardList")
  public List<BoardList> selectBoardList(/* @RequestParam Map<String, Object> paramMap */) {

    List<BoardList> boardList = new ArrayList<BoardList>();

    boardList = boardService.selectBoardList();


    return boardList;
  }

}
