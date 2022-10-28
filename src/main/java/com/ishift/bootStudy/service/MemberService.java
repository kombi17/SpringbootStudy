package com.ishift.bootStudy.service;

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
}
