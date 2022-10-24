package com.ishift.bootStudy.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ishift.bootStudy.dao.UserDAOImpl;
import com.ishift.bootStudy.model.vo.Pagination;
// import com.ishift.bootStudy.mapper.UserMapper;
import com.ishift.bootStudy.model.vo.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService{
	// 회원가입 시 저장시간을 넣어줄 DateTime형
    SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

//    @Autowired
//    UserMapper userMapper;

    @Autowired
    UserDAOImpl userMapper;
    
    @Transactional
    public void joinUser(User user){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));
//        user.setUserName(user.getUserName());
//        user.setUserNickname(user.getUserNickname());
//        user.setUserGender(user.getUserGender());
//        user.setUserHobby(user.getUserHobby());
//        user.setUserEmail(user.getUserEmail());
//        user.setUserTel(user.getUserTel());
//        user.setUserAddress(user.getUserAddress());
//        user.setUserAddressDetail(user.getUserAddressDetail());
        user.setUserAuth("USER");
        user.setAppendDate(localTime);
        user.setUpdateDate(localTime);
        userMapper.saveUser(user);
    }
    
	@Override
	public User loadUserByUsername(String userId) throws UsernameNotFoundException {
		//여기서 받은 유저 패스워드와 비교하여 로그인 인증
		User user = userMapper.getUserAccount(userId);
        if (user == null){
            throw new UsernameNotFoundException(userId);
        }
        return user;
	}
	
	/**
	 * 이메일 중복 체크
	 */
	@Override
	public int emailDupCheck(String inputEmail) {
		return userMapper.emailDupCheck(inputEmail);
	}
	
	
	/**
	 * 회원 목록 조회
	 * @param cp 
	 * @return
	 */
	@Override
	public Map<String, Object> selectAllUser(int cp){
		
		int listCount = userMapper.countUser();
		Pagination pagination = new Pagination(cp, listCount);
		
		List<User> userList = userMapper.selectAllUser(pagination);
		
		Map<String , Object> map = new HashMap<String, Object>();
		
		map.put("pagination", pagination);
		map.put("userlist", userList);
		
		return map;
	}
	
	/**
	 * 로그인 한 회원 정보 조회
	 * @param userId 
	 * @return
	 */
	@Override
	public User selectLoginUser(String userId) {
		return userMapper.selectLoginUser(userId);
	}

	
	
	
}
