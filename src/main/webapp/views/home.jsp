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

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,900&family=Silkscreen&display=swap"
      rel="stylesheet"
    />

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
          <div>
            <c:choose>
              <c:when test="${sessionScope.greeting eq null}">
                <h1>Hello, there! Here is INDEX Page!</h1>

                <h2>
                  When you want to use this service, please
                  <a href="/user/loginForm" id="loginLink">LOGIN!</a>
                </h2>
              </c:when>
              <c:otherwise> <h2>${sessionScope.greeting}</h2> </c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>
    </main>

    <%@ include file="../views/common/footer.jsp" %>

    <script src="/resources/js/common.js"></script>
  </body>
</html>
