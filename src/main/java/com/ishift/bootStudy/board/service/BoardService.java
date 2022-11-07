package com.ishift.bootStudy.board.service;

import java.util.List;
import com.ishift.bootStudy.board.model.vo.BoardList;

public interface BoardService {
  
  List<BoardList> selectBoardList();

}
