package com.ishift.bootStudy.board.dao;

import java.util.List;
import java.util.Map;
import com.ishift.bootStudy.board.model.vo.BoardDetail;
import com.ishift.bootStudy.board.model.vo.BoardList;

public interface BoardDAO {

  // 게시글 목록 조회
  List<BoardList> selectBoardList(Map<String, Object> paramMap);

  // 게시글 상세내역 조회
  BoardDetail selectBoardDetail(String boardNo);

  // 게시글 삭제
  int deleteBoardDetail(String boardNo);

  // 게시글 삽입
  int insertBoard(Map<String, Object> paramMap);

  // 조회수 증가
  int updateReadCount(String boardNo);
  
  // 게시글 수정
  int updateBoard(Map<String, Object> paramMap);
}
