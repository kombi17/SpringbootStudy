package com.ishift.bootStudy.model.vo;

import lombok.Data;

@Data
public class RegisterUser {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private String userNickname;
	private String userGender;
	private String userHobby;
	private String userEmail;
	private String userTel;
	private String userAddress;
	private String userAuth;
	private String appendDate;
	private String updateDate;
}
