<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
      <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
          <meta charset="UTF-8" />
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <meta name="viewport" content="width=device-width, initial-scale=1.0" />

          <link rel="stylesheet" href="/resources/css/common.css" />
          <link rel="stylesheet" href="/resources/css/board/boardDetail-style.css" />

          <script src="https://kit.fontawesome.com/245c493145.js" crossorigin="anonymous"></script>

          <!-- jQuery -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
          <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
          <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>

          <title>BoardDetail</title>
        </head>

        <body>
          <main>
            <!-- header -->
            <%@ include file="/views/common/header.jsp" %>
              <div class="content">
                <!-- sidebar -->
                <%@ include file="/views/common/sidebar.jsp" %>
                  <!-- main-content -->
                  <div class="main-content">
                    <h2 class="board-title">${detail.boardTitle}</h2>
                    <div class="board-header">
                      <div class="board-writer">
                        <span>${detail.userNickname} &nbsp; &nbsp; @${detail.userId}</span>
                      </div>
                      <div class="board-info">
                        <p><span>작성일</span> ${detail.createDate}</p>

                        <!-- 수정된 게시물일 경우 수정일 출력 -->
                        <c:if test="${!empty detail.updateDate}">
                          <p>
                            <span>수정일</span> ${detail.updateDate}
                          </p>
                        </c:if>

                        <p><span>조회수</span> ${detail.readCount}</p>
                      </div>
                    </div>

                    <div class="board-content">${detail.boardContent}</div>
                    <!-- 로그인 한 사용자와 글 쓴 사람이 같은 경우 -->
                    <div class="btn-area">
                      <button type="button" id="goToList">목록으로</button>
                      <c:if test="${userId eq detail.userId}">
                        <button type="button" id="deleteBtn">삭제</button>
                        <button type="button" id="modifyBtn">수정</button>
                      </c:if>
                    </div>
                  </div>
              </div>
          </main>
          <!-- footer -->
          <%@ include file="/views/common/footer.jsp" %>
        </body>

        <script>
          const boardNo = "${ detail.boardNo }";
        </script>

        <!-- common.js -->
        <script src="/resources/js/common.js"></script>

        <!-- boardDetail.js -->
        <script src="/resources/js/board/boardDetail.js"></script>

        </html>