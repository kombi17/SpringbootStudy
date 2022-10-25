package com.ishift.bootStudy.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishift.bootStudy.model.vo.Pagination;
import com.ishift.bootStudy.model.vo.RegisterUser;
import com.ishift.bootStudy.model.vo.User;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public User getUserAccount(String userId) {
		return sqlSession.selectOne("userMapper.getUserAccount", userId);
	}

	@Override
	public void signUp(RegisterUser registerUser) {
		sqlSession.insert("userMapper.signUp", registerUser);
	}

	@Override
	public int countUser() {
		return sqlSession.selectOne("userMapper.countUser");
	}
	
	@Override
	public List<User> selectAllUser(Pagination pagination) {
		
		int offset = (pagination.getCurrentPage()-1) * pagination.getLimit();
		
		RowBounds rowbounds = new RowBounds(offset, pagination.getLimit());
		
		return sqlSession.selectList("userMapper.selectAllUser", null, rowbounds);
	}

	@Override
	public User selectLoginUser(String userId) {
		return sqlSession.selectOne("userMapper.selectLoginUser", userId);
	}

	public int emailDupCheck(String inputEmail) {
		return sqlSession.selectOne("userMapper.emailDupCheck", inputEmail);
	}

	

}
