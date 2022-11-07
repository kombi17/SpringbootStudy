package com.ishift.bootStudy.board.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ishift.bootStudy.board.model.vo.BoardList;

@Repository
public class BoardDAOImpl implements BoardDAO {
  
  @Autowired
  private SqlSessionTemplate sqlSession;

  @Override
  public List<BoardList> selectBoardList() {
    return sqlSession.selectList("boardMapper.selectBoardList");
  }

}
