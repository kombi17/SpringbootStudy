<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,900&family=Silkscreen&display=swap"
      rel="stylesheet" />

    <div id="sidebar">
      <div id="sidebar-list">
        <div id="sidebar-title">
          <a href="/"><i class="fa-solid fa-book-open"></i> kombi asgmt</a>
        </div>
        <sec:authorize access="isAuthenticated()">
          <div class="sidebar-menu">
            <a href="/user/memberList"><i class="fa-regular fa-rectangle-list"></i> User List</a>
          </div>
          <div class="sidebar-menu">
            <a href="/user/memberSecession"><i class="fa-regular fa-rectangle-list"></i> 회원 탈퇴</a>
          </div>
          <div class="sidebar-menu">
            <a href="/logout" id="logout-btn"><i class="fa-regular fa-circle-xmark"></i> logout</a>
          </div>
        </sec:authorize>
      </div>
    </div>