package com.ishift.bootStudy.dao;

import java.util.List;
import java.util.Map;

import com.ishift.bootStudy.model.vo.Member;
import com.ishift.bootStudy.model.vo.Pagination;

public interface MemberDAO {

  // 로그인
  Member getUserAccount(String username);

  // 회원가입
  int signUp(Member registerUser);

  // 회원 수 조회
  int countUser();

  // 회원 목록 조회
  List<Member> selectAllUser(Pagination pagination);

  // 로그인 한 회원 정보 조회
  Member selectLoginUser(String userId);

  // 아이디 중복 체크
  int idDupCheck(String inputId);

  // 회원 정보 수정
  int userUpdate(Map<String, Object> paramMap);
  
  // 회원 전체 조회 (검색 포함)
  List<Member> selectMemberList(Map<String, Object> paramMap);

  // 회원 탈퇴
  int memberSecession(int userNo);
  
}
