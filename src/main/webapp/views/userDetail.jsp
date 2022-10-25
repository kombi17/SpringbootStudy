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

    <link rel="stylesheet" href="\resources\css\common.css" />
    <link rel="stylesheet" href="\resources\css\input-style.css" />

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
            <form method="post" action="/user/detail/update" onsubmit="return infoValidate()">
              <div>${loginuser.userId} 님의 회원 정보를 수정합니다.</div>

              <div class="input-content">
                <label for="userNickname">닉네임</label>
                <input type="text" id="userNickname" name="userNickname" autocomplete="off" value="${loginuser.userNickname}" />
              </div class="input-content">

              <div class="input-content">
                <label for="userEmail">E-mail</label>
                <input type="text" id="userEmail" name="userEmail" autocomplete="off" value="${loginuser.userEmail}" />
              </div class="input-content">

              <div class="input-content">
                <label for="userTel">전화번호</label>
                <input type="text" id="userTel" name="userTel" autocomplete="off" value="${loginuser.userTel}" />
              </div class="input-content">


              <c:set var="address" value="${fn:split(loginuser.userAddress, ',,')}" />
              <div class="input-content">
                <label for="sample4_postcode">주소</label>
                <input type="text" id="sample4_postcode" name="userAddress" autocomplete="off" value="${address[0]}" />
                <input type="button" name="userAddress" onclick="sample4_execDaumPostcode()" value="검색"><br>
              </div>
              <div class="input-content">
                <label for="sample4_roadAddress">도로명 주소</label>
                <input type="text" id="sample4_roadAddress" name="userAddress" autocomplete="off" value="${address[1]}" />
              </div>
              <div class="input-content">
                <label for="sample4_detailAddress">상세 주소</label>
                <input type="text" id="sample4_detailAddress" name="userAddress" autocomplete="off" value="${address[2]}" />
              </div>

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
    <script src="\resources\js\common.js"></script>
    <script src="\resources\js\userDetail.js"></script>
  </body>
</html>
