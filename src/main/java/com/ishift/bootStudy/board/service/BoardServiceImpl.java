package com.ishift.bootStudy.board.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ishift.bootStudy.board.dao.BoardDAOImpl;
import com.ishift.bootStudy.board.model.vo.BoardList;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

  @Autowired
  BoardDAOImpl boardDAO;

  public List<BoardList> selectBoardList() {
    return boardDAO.selectBoardList();
  }
}
