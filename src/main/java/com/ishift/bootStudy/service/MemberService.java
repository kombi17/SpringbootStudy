package com.ishift.bootStudy.service;

import java.util.List;
import java.util.Map;

import com.ishift.bootStudy.model.vo.Member;

public interface MemberService {

  // 목록 조회
  Map<String, Object> selectAllUser(int cp);

  // 로그인 한 회원 정보 조회
  Member selectLoginUser(String userId);

  // 아이디 중복 체크
  int idDupCheck(String inputId);

  // 회원 정보 수정
  int userUpdate(Map<String, Object> paramMap);
  
  // 회원 전체 조회
  List<Member> selectMemberList(Map<String, Object> paramMap);
  
  // 검색 조건에 일치하는 회원 조회
  List<Member> searchMemberList();
}
