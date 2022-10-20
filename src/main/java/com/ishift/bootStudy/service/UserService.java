package com.ishift.bootStudy.service;

import java.util.List;

import com.ishift.bootStudy.model.vo.User;

public interface UserService {
	
	// 목록 조회
	List<User> selectAllUser();
	
	// 로그인 한 회원 정보 조회
	User selectLoginUser(String userId);
	
	// 로그인 한 회원의 비밀번호 조회 
	int checkPw(int userNo, String userPw);
}
