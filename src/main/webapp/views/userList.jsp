<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>asgmt</title>

    <c:set var="pagination" value="${map.pagination}" />
    <c:set var="userlist" value="${map.userlist}" />

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />

    <link rel="stylesheet" href="../resources/css/common.css" />
    <link rel="stylesheet" href="../resources/css/userList-style.css" />

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
        <div id="main-content" >
          <div id="scroll-box">
            <div class="container">
              <!-- 컬럼 제목 -->
              <div class="item columnTitle">아이디</div>
              <div class="item columnTitle">이름</div>
              <div class="item columnTitle">닉네임</div>
              <div class="item columnTitle">성별</div>
              <div class="item columnTitle">취미</div>
              <div class="item columnTitle">이메일</div>
              <div class="item columnTitle">전화번호</div>
              <div class="item columnTitle">주소</div>
              <div class="item columnTitle">권한</div>
              <div class="item columnTitle">가입 날짜</div>
              <div class="item columnTitle">수정 날짜</div>
              <!-- 내용 -->
              <c:forEach var="user" items="${userlist}">
                <div class="item">
                  <a
                    id="goToUserDetailPage"
                    href="/user/detail/${user.userNo}?cp=${pagination.currentPage}"
                    >${user.userId}
                  </a>
                </div>
                <div class="item">${user.userName}</div>
                <div class="item">${user.userNickname}</div>
                <div class="item">${user.userGender}</div>
                <div class="item">
                  ${fn:replace(user.userHobby, ',,', ', ')}
                </div>
                <div class="item">${user.userEmail}</div>
                <div class="item">${user.userTel}</div>
                <div class="item" style="justify-content: start;">
                  ${fn:replace(user.userAddress, ',,', '<br>')}
                </div>
                <div class="item">${user.userAuth}</div>
                <div class="item">${user.appendDate}</div>
                <div class="item">${user.updateDate}</div>
              </c:forEach>
            </div>
          </div>
        </div>
      </div>

      <c:if test="${!empty pagination}">
        <%-- 페이지네이션 --%>
        <div class="pagination-area">
          <!-- 페이지네이션 a태그에 사용될 공통 주소를 저장한 변수 선언 -->
          <c:set var="url" value="?cp=" />
          <%-- selectAll?cp= --%>

          <ul class="pagination">
            <!-- 첫 페이지로 이동 -->
            <li>
              <a href="${url}1"><i class="fa-solid fa-angles-left"></i></a>
            </li>

            <!-- 이전 목록 마지막 번호로 이동 -->
            <li>
              <a href="${url}${pagination.prevPage}"
                ><i class="fa-solid fa-angle-left"></i
              ></a>
            </li>

            <!-- 범위가 정해진 일반 for문 사용 -->
            <c:forEach
              var="i"
              begin="${pagination.startPage}"
              end="${pagination.endPage}"
              step="1"
            >
              <c:choose>
                <c:when test="${i == pagination.currentPage}">
                  <li><a class="current">${i}</a></li>
                </c:when>

                <c:otherwise>
                  <li><a href="${url}${i}">${i}</a></li>
                </c:otherwise>
              </c:choose>
            </c:forEach>

            <!-- 다음 목록 시작 번호로 이동 -->
            <li>
              <a href="${url}${pagination.nextPage}"
                ><i class="fa-solid fa-angle-right"></i
              ></a>
            </li>

            <!-- 끝 페이지로 이동 -->
            <li>
              <a href="${url}${pagination.maxPage}"
                ><i class="fa-solid fa-angles-right"></i
              ></a>
            </li>
          </ul>
        </div>
      </c:if>
    </main>

    <script src="../resources/js/common.js"></script>
  </body>
</html>
