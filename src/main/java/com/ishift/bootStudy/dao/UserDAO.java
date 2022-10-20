package com.ishift.bootStudy.dao;

import java.util.List;

import com.ishift.bootStudy.model.vo.User;

public interface UserDAO {
	
	// 로그인
    User getUserAccount(String userId);
	
    // 회원가입
	void saveUser(User user);
	
	// 회원 목록 조회
	List<User> selectAllUser();

	// 로그인 한 회원 정보 조회
	User selectLoginUser(String userId);
	
	// 로그인 한 회원의 현재 비밀번호 조회
	String checkPw(int userNo);

}
