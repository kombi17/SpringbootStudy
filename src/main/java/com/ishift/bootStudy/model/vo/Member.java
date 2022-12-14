package com.ishift.bootStudy.model.vo;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Member implements UserDetails {

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

  // UserDetailService를 구현한 UserServiceImpl에 있는
  // loadUserByUsername() 메서드 에서 반환한 User VO 내용과 권한을 UserDetails를 implement한
  // User객체에서

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singletonList(new SimpleGrantedAuthority(this.userAuth));
  }

  @Override
  public String getPassword() {
    return this.userPw;
  }

  // 시큐리티의 username
  // -> 따라서 얘는 인증할 때 id를 봄
  @Override
  public String getUsername() {
    return this.userId;
  }

  // Vo의 userName !
  public String getUserName() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
