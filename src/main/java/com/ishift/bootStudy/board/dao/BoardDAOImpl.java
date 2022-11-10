package com.ishift.bootStudy.board.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ishift.bootStudy.board.model.vo.BoardDetail;
import com.ishift.bootStudy.board.model.vo.BoardList;

@Repository
public class BoardDAOImpl implements BoardDAO {

  @Autowired
  private SqlSessionTemplate sqlSession;

  @Override
  public List<BoardList> selectBoardList(Map<String, Object> paramMap) {
    return sqlSession.selectList("boardMapper.selectBoardList", paramMap);
  }

  @Override
  public BoardDetail selectBoardDetail(String boardNo) {
    return sqlSession.selectOne("boardMapper.selectBoardDetail", boardNo);
  }

  @Override
  public int deleteBoardDetail(String boardNo) {
    return sqlSession.update("boardMapper.deleteBoardDetail", boardNo);
  }

  @Override
  public int insertBoard(Map<String, Object> paramMap) {
    return sqlSession.insert("boardMapper.insertBoard", paramMap);
  }
  
}
