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

              <div class="input-content">
                <label for="userNickname">닉네임</label>
                <input type="text" id="userNickname" name="userNickname" autocomplete="off"  />
              </div class="input-content">
              <span class="signUp-msg" id="nicknameMsg">영어, 숫자, 한글 2~10자 사이로 작성해주세요.</span>

              <div class="input-content">
                <label for="userEmail">E-mail</label>
                <input type="text" id="userEmail" name="userEmail" autocomplete="off" />
              </div class="input-content">
              <span class="signUp-msg" id="emailMsg">메일을 받을 수 있는 이메일을 입력해주세요.</span>

              <div class="input-content">
                <label for="userTel">전화번호</label>
                <input type="text" id="userTel" name="userTel" autocomplete="off" />
              </div class="input-content">
              <span class="signUp-msg" id="telMsg">전화번호를 입력해주세요.(- 제외)</span>


              <!-- API 사용 -->
              <div class="input-content">
                <label for="sample4_postcode">주소</label>
                <input type="text" id="sample4_postcode" name="userAddress" autocomplete="off">
                <input type="button" name="userAddress" onclick="sample4_execDaumPostcode()" value="검색"><br>
              </div>
              <div class="input-content">
                <label for="sample4_roadAddress">도로명 주소</label>
                <input type="text" id="sample4_roadAddress" name="userAddress" autocomplete="off">
              </div>
              <div class="input-content">
                <label for="sample4_detailAddress">상세 주소</label>
                <input type="text" id="sample4_detailAddress" name="userAddress" autocomplete="off">
              </div>

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
              <span class="signUp-msg" id="hobbyMsg">1개 이상의 취미를 선택해주세요.</span>

              <div class="btn-area">
                <button type="submit" class="modify-btn">회원 정보 수정</button>
                <button type="reset" class="reset-btn">초기화</button>
                <button type="button" id="goToList" >목록으로</button>

              </div>
            </form>
          </div>
        </div>
      </div>
    </main>

    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- js -->
    <script src="/resources/js/common.js"></script>
  </body>
</html>
