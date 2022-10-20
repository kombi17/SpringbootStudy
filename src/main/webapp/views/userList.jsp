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
    <link rel="stylesheet" href="/resources/css/userList-style.css" />

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

        <!-- main-content -->
        <div id="main-content">
          <div class="container">
            <!-- 컬럼 제목 -->
            <div class="item columnTitle">아이디</div>
            <div class="item columnTitle">이름</div>
            <div class="item columnTitle">가입 날짜</div>
            <!-- 내용 -->
            <c:forEach var="user" items="${userlist}">
              <div class="item">${user.userId}</div>
              <div class="item">${user.userName}</div>
              <div class="item">${user.appendDate}</div>
            </c:forEach>
          </div>
        </div>
      </div>
    </main>

    <script src="/resources/js/common.js"></script>
  </body>
</html>
