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
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public Member getUserAccount(String username) {
//		System.out.println(username + "333");
		
		Member loginUser = sqlSession.selectOne("memberMapper.getUserAccount", username);
//		System.out.println(loginUser.getUserPw() + "333");
		return loginUser;
	}

	@Override
	public int signUp(Member member) {
		return sqlSession.insert("memberMapper.signUp", member);
	}

	@Override
	public int countUser() {
		return sqlSession.selectOne("memberMapper.countUser");
	}
	
	@Override
	public List<Member> selectAllUser(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("memberMapper.selectAllUser", null, rowbounds);
	}

	@Override
	public Member selectLoginUser(String userId) {
		return sqlSession.selectOne("memberMapper.selectLoginUser", userId);
	}

	public int emailDupCheck(String inputEmail) {
		return sqlSession.selectOne("memberMapper.emailDupCheck", inputEmail);
	}

	public int userUpdate(Map<String, Object> paramMap) {
		// 파라미터가 map인 경우 mapper에서 사용할 때 #{key}를 적으면
		// key에 대응하는 value 출력
		return sqlSession.update("memberMapper.userUpdate", paramMap);
	}

	

}
