package com.ishift.bootStudy.board.service;

import java.util.List;
import java.util.Map;
import com.ishift.bootStudy.board.model.vo.BoardDetail;
import com.ishift.bootStudy.board.model.vo.BoardList;

public interface BoardService {

  // 게시글 목록 조회
  List<BoardList> selectBoardList(Map<String, Object> paramMap);

  // 게시글 상세내역 조회
  BoardDetail selectBoardDetail(String boardNo);
  
  // 게시글 삭제
  int deleteBoardDetail(String boardNo);

}
