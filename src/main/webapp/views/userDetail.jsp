<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>asgmt</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" href="/resources/css/common.css" />
    <link rel="stylesheet" href="/resources/css/input-style.css" />

    <script
      src="https://kit.fontawesome.com/245c493145.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <main>
      <!-- header -->
      <%@ include file="/views/common/header.jsp" %>

      <div class="content">
        <!-- sidebar -->
        <%@ include file="/views/common/sidebar.jsp" %>

        <!-- 본문 -->
        <div id="main-content">
          <div class="container">
            <h1>myPage</h1>
            <form method="post" action="/user/myPage">
              <div>${loginuser.userId} 님의 회원 정보를 수정합니다.</div>
              <!-- 변경할 비밀번호 -->
              <div class="input-content">
                <label for="userPw">New PW</label>
                <input
                  type="password"
                  id="changedUserPw"
                  name="changedUserPw"
                />
              </div>

              <!-- 이름 -->
              <div class="input-content">
                <label for="userName">이름</label>
                <input
                  type="text"
                  id="userName"
                  name="userName"
                  autocomplete="off"
                />
              </div>

              <!-- 닉네임 -->
              <div class="input-content">
                <label for="userNickname">닉네임</label>
                <input type="text" id="userNickname" name="userNickname" autocomplete="off"  />
              </div class="input-content">

              <!-- 이메일 -->
              <div class="input-content">
                <label for="userEmail">E-mail</label>
                <input type="text" id="userEmail" name="userEmail" autocomplete="off" />
              </div class="input-content">

              <!-- 전화번호 -->
              <div class="input-content">
                <label for="userTel">전화번호</label>
                <input type="text" id="userTel" name="userTel" autocomplete="off" />
              </div class="input-content">

              <!-- 주소 - API 사용 -->
              <div class="input-content">
                <label for="userAddress">주소</label>
                <input type="text" id="sample4_postcode" name="userAddress" placeholder="우편번호">
                <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="sample4_roadAddress" name="userAddress" placeholder="도로명주소">
                <input type="text" id="sample4_detailAddress" name="userAddress" placeholder="상세주소">
              </div class="input-content">



              <button type="submit" class="submit-btn">회원 정보 수정</button>
            </form>
          </div>
        </div>
      </div>
    </main>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- js -->
    <script src="../resources/js/common.js"></script>
  </body>
</html>
