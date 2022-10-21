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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
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
            <h1>Sign Up</h1>
			<hr>
            <form
              method="post"
              action="/user/signUp"
              onsubmit="return inputValidate()"
            >
              <div class="input-content">
                <label for="userId">ID</label>
                <input
                  type="text"
                  id="userId"
                  name="userId"
                  autocomplete="off"
                />
              </div>

              <div class="input-content">
                <label for="userPw">PW</label>
                <input type="password" id="userPw" name="userPw" />
              </div>

              <div class="input-content">
                <label for="userName">이름</label>
                <input type="text" id="userName" name="userName" autocomplete="off" />
              </div class="input-content">

              <div class="input-content">
                <label for="userNickname">닉네임</label>
                <input type="text" id="userNickname" name="userNickname" autocomplete="off" />
              </div class="input-content">

              <div class="input-content">
                <div class="input-title">성별</div>
                <label for="male">male</label>
                <input type="radio" name="userGender" id="male" />
                <label for="female">female</label>
                <input type="radio" name="userGender" id="female" />
              </div class="input-content">


              <div class="input-content">
                <div class="input-title">취미</div>
                <label for="book">독서</label>
                <input type="checkbox" name="userHobby" id="book" value="book" />

                <label for="music">음악 감상</label>
                <input type="checkbox" name="userHobby" id="music" value="music" />

                <label for="movie">영화 감상</label>
                <input type="checkbox" name="userHobby" id="movie" value="movie" />

                <label for="knitting">뜨개질</label>
                <input type="checkbox" name="userHobby" id="knitting" value="knitting" />

                <label for="baking">베이킹</label>
                <input type="checkbox" name="userHobby" id="baking" value="baking" />
              </div class="input-content">


              <div class="input-content">
                <label for="userEmail">E-mail</label>
                <input type="text" id="userEmail" name="userEmail" autocomplete="off" />
              </div class="input-content">

              <div class="input-content">
                <label for="userTel">전화번호</label>
                <input type="text" id="userTel" name="userTel" autocomplete="off" />
              </div class="input-content">

              <!-- API 사용 -->
              <div class="input-content">
                <label for="userAddress">주소</label>
                <input type="text" id="userAddress" name="userAddress" autocomplete="off" />
              </div class="input-content">

              <!-- 입력 -->
              <div class="input-content">
                <label for="userAddressDetail">상세주소</label>
                <input type="text" id="userAddressDetail" name="userAddressDetail" autocomplete="off" />
              </div class="input-content">

              <button type="submit" class="submit-btn">회원 가입</button>
            </form>
          </div>
        </div>
      </div>
    </main>

    <script src="/resources/js/signUp.js"></script>
  </body>
</html>
