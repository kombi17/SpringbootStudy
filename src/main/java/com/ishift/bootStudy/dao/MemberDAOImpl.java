package com.ishift.bootStudy.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishift.bootStudy.model.vo.Member;
import com.ishift.bootStudy.model.vo.Pagination;

@Repository
public class MemberDAOImpl implements MemberDAO {

  @Autowired
  private SqlSessionTemplate sqlSession;

  // 로그인
  @Override
  public Member getUserAccount(String username) {

    Member loginUser = sqlSession.selectOne("memberMapper.getUserAccount", username);
    return loginUser;
  }

  // 회원 가입
  @Override
  public int signUp(Member member) {
    return sqlSession.insert("memberMapper.signUp", member);
  }

  // 페이지네이션 사용을 위해 회원 수 조회
  @Override
  public int countUser() {
    return sqlSession.selectOne("memberMapper.countUser");
  }

  // 회원 목록 조회
  @Override
  public List<Member> selectAllUser(Pagination pagination) {

    // Mybatis에서 제공하는 rowbounds 객체 사용

    // 전체 조회 결과에서 몇 개의 행을 건너 뛰고(offset)
    // 그 다음 몇 개의 행만(limit) 조회할 것인지 지정
    int offset = (pagination.getCurrentPage() - 1) * pagination.getLimit();

    RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());

    return sqlSession.selectList("memberMapper.selectAllUser", null, rowbounds);
  }

  // 회원 1명의 정보 조회
  @Override
  public Member selectLoginUser(String userId) {
    return sqlSession.selectOne("memberMapper.selectLoginUser", userId);
  }

  // 아이디 중복 체크
  public int idDupCheck(String inputId) {
    return sqlSession.selectOne("memberMapper.idDupCheck", inputId);
  }

  // 회원 정보 수정
  public int userUpdate(Map<String, Object> paramMap) {
    // 파라미터가 map인 경우 mapper에서 사용할 때 #{key}를 적으면
    // key에 대응하는 value 출력
    return sqlSession.update("memberMapper.userUpdate", paramMap);
  }

  // 회원 전체 조회(검색 포함)
  public List<Member> selectMemberList(Map<String, Object> paramMap) {
    return sqlSession.selectList("memberMapper.selectMemberList", paramMap);
  }

  @Override
  public int memberSecession(String userPw) {
    return sqlSession.update("memberMapper.memberSecession", userPw);
  }




}
