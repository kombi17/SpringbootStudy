package com.ishift.bootStudy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ishift.bootStudy.dao.MemberDAOImpl;
import com.ishift.bootStudy.model.vo.Member;
import com.ishift.bootStudy.model.vo.Pagination;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements UserDetailsService, MemberService {

  @Autowired
  MemberDAOImpl memberMapper;

  // 로그인
  @Override
  public Member loadUserByUsername(String username) throws UsernameNotFoundException {

    // System.out.println(username + "222");

    // 여기서 받은 유저 패스워드와 비교하여 로그인 인증
    Member user = memberMapper.getUserAccount(username);

    if (user == null) {
      throw new UsernameNotFoundException(username);
    }
    return user;
  }

  // 회원가입 시 저장시간을 넣어줄 DateTime형
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  Date time = new Date();
  String localTime = format.format(time);

  // 회원가입
  @Transactional
  public int signUp(Member member) {
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    // bcrypt를 이용한 비밀번호 암호화
    String encodedPw = bcrypt.encode(member.getUserPw());

    // 암호화 된 비밀번호로 세팅
    member.setUserPw(encodedPw);

    // view에서 input되지 않은 값 세팅
    member.setUserAuth("USER");
    member.setAppendDate(localTime);
    member.setUpdateDate(localTime);

    // DAO 호출
    int result = memberMapper.signUp(member);

    return result;
  }

  /**
   * 아이디 중복 체크
   */
  @Override
  public int idDupCheck(String inputId) {
    return memberMapper.idDupCheck(inputId);
  }

  /**
   * 회원 목록 조회
   * 
   * @param cp
   * @return
   */
  @Override
  public Map<String, Object> selectAllUser(int cp) {

    // 페이지네이션 객체 생성
    int listCount = memberMapper.countUser();
    Pagination pagination = new Pagination(cp, listCount);

    // 게시글 목록 조회
    List<Member> userList = memberMapper.selectAllUser(pagination);

    // Map에 담아서 반환
    Map<String, Object> map = new HashMap<String, Object>();

    map.put("pagination", pagination);
    map.put("userlist", userList);

    return map;
  }

  /**
   * 로그인 한 회원 정보 조회
   * 
   * @param userId
   * @return
   */
  @Override
  public Member selectLoginUser(String userId) {
    return memberMapper.selectLoginUser(userId);
  }

  /**
   * 회원 정보 수정
   * 
   * @param paramMap
   */
  public int userUpdate(Map<String, Object> paramMap) {

    // 수정 날짜
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    String localTime = format.format(time);

    paramMap.put("updateDate", localTime);

    return memberMapper.userUpdate(paramMap);
  }

  /**
   * 회원 전체 목록 조회 (검색 포함)
   */
  public List<Member> selectMemberList(Map<String, Object> paramMap) {
    return memberMapper.selectMemberList(paramMap);
  }


}
