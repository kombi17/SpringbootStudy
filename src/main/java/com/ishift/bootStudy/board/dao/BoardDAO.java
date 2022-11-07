package com.ishift.bootStudy.board.dao;

import java.util.List;
import com.ishift.bootStudy.board.model.vo.BoardList;

public interface BoardDAO {
  
  List<BoardList> selectBoardList();

}
