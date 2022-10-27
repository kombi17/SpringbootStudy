<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>asgmt</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="/resources/css/common.css">
  <link rel="stylesheet" href="/resources/css/input-style.css">
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://kit.fontawesome.com/245c493145.js" crossorigin="anonymous"></script>
  
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
					<h1>Login</h1> 
					<hr>
					<c:if test="${error eq 'true'}"><span id="error">로그인 실패!</span></c:if>
					<br>
					<span id="exception">${exception}</span> 
					<form action="/user/login" method="post" onsubmit="return inputValidate()"> 
						<div class="input-content"> <label for="username">ID</label> <input type="text" id="username" name="username" autocomplete="off" /> </div> 
						<div class="input-content"> <label for="password">PW</label> <input type="password" id="password" name="password" /> </div> 
						<div class="input-content"> <input type="checkbox" name="remember-me" id="saveIdCheckbox" /> <label for="saveIdCheckbox">   Save </label> </div> 
						<button type="submit" class="submit-btn"> login </button>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
					</form>
				</div>
			</div>
		</div>
	</main>

	<%@ include file="../views/common/footer.jsp" %>
	
	<!-- js -->
	<script src="/resources/js/login.js" /></script>

</body>
</html>