package com.ishift.bootStudy.board.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ishift.bootStudy.board.dao.BoardDAOImpl;
import com.ishift.bootStudy.board.model.vo.BoardDetail;
import com.ishift.bootStudy.board.model.vo.BoardList;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardDAOImpl boardDAO;

  public List<BoardList> selectBoardList(Map<String, Object> paramMap) {
    return boardDAO.selectBoardList(paramMap);
  }

  public BoardDetail selectBoardDetail(String boardNo) {
    return boardDAO.selectBoardDetail(boardNo);
  }

  public int deleteBoardDetail(String boardNo) {
    return boardDAO.deleteBoardDetail(boardNo);
  }

  public int insertBoard(Map<String, Object> paramMap) {
    
    return boardDAO.insertBoard(paramMap);
  }

  public int updateReadCount(String boardNo) {
    return boardDAO.updateReadCount(boardNo);
  }

  public int updateBoard(Map<String, Object> paramMap) {
    System.out.println("service22222");
    return boardDAO.updateBoard(paramMap);
  }
}
