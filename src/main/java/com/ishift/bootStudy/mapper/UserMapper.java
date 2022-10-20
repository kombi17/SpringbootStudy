//package com.ishift.bootStudy.mapper;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//
//import com.ishift.bootStudy.model.vo.User;
//
//@Mapper
//public interface UserMapper {
//	
//	// DAO와 Mapper의 차이
//	// DAO : Data Access Object, 실질적으로 DB에 접근하여 데이터를 조회하거나 조작하는 기능을 전담하는 객체
//	// 		 효율적인 커넥션 관리와 보안성이 장점
//	// Mapper : mybatis 3.0 부터 생긴 mybatis 매핑 xml에 기재된 sql을 호출하기 위한 인터페이스
//	
//	// mapper 인터페이스 사용 전
//	// sqlSession등록, DAO인터페이스와 DAO클래스 생성, 네임스페이스.sqlId로 지정하여 sql 호출
//	// selectOne, insert, delete 와 같이 제공하는 메서드 사용
//	
//	
//	
//	// 로그인
//    User getUserAccount(String userId);
//	
//    // 회원가입
//	void saveUser(User user);
//	
//	// 회원 목록 조회
//	List<User> selectAllUser();
//
//	// 로그인 한 회원 정보 조회
//	User selectLoginUser(String userId);
//}
