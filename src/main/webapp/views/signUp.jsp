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
              <button type="submit" class="submit-btn">회원 가입</button>
            </form>
          </div>
        </div>
      </div>
    </main>

    <script src="/resources/js/signUp.js"></script>
  </body>
</html>
