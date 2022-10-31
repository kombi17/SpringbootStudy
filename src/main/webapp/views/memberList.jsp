<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%> <%@ taglib prefix="sec"
uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="../resources/css/common.css" />
    <link rel="stylesheet" href="../resources/css/memberList-style.css" />
    <script
      src="https://kit.fontawesome.com/245c493145.js"
      crossorigin="anonymous"
    ></script>
    <link
      rel="stylesheet"
      type="text/css"
      href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css"
    />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script
      type="text/javascript"
      src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"
    ></script>
    <!-- jQuery 라이브러리 추가 -->

    <title>asgmt</title>
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
            <table id="memberList" class="display nowrap">
              <thead>
                <tr>
                  <th class="title">No</th>
                  <th class="title">아이디</th>
                  <th class="title">이름</th>
                  <th class="title">닉네임</th>
                  <th class="title">성별</th>
                  <th class="title">취미</th>
                  <th class="title">이메일</th>
                  <th class="title">전화번호</th>
                  <th class="title">주소</th>
                  <th class="title">권한</th>
                  <th class="title">가입날짜</th>
                  <th class="title">수정날짜</th>
                </tr>
              </thead>
              <tbody></tbody>
            </table>
          </div>
        </div>
      </div>
    </main>

    <!-- footer -->
    <%@ include file="../views/common/footer.jsp" %>

    <script>
      $(function () {
        $.ajax({
          url: "selectMemberList",
        }).done(function (data) {
          var table = $("#memberList").DataTable({
            data: data,
            dataSrc: "",
            columns: [
              {
                data: "userNo",
              },
              {
                data: "userId",
                render: function (data, type, row) {
                  data = "<a href=/user/detail/" + data + ">" + data + "</a>";
                  return data;
                },
              },
              { data: "userName" },
              { data: "userNickname" },
              { data: "userGender" },
              {
                data: "userHobby",
                render: function (data, type, row) {
                  data = data.replace(/,,|,,|,,|,,|,,/g, ", ");
                  return data;
                },
              },
              { data: "userEmail" },
              {
                data: "userTel",
                render: function (data, type, row) {
                  data = data.replace(/(\d{3})(\d{3,4})(\d{4})/, "$1-$2-$3");
                  return data;
                },
              },
              {
                data: "userAddress",
                render: function (data, type, row) {
                  data = data.replace(/,,|,,/g, "&nbsp;");
                  return data;
                },
              },
              { data: "userAuth" },
              { data: "appendDate" },
              { data: "updateDate" },
            ],
            columnDefs: [
              { targets: [1, 2, 3, 4, 9], width: 80 },
              { targets: [5, 6, 7, 10, 11], width: 150 },
              { targets: 8, width: 400 },
              { targets: [0, 9], visible: false },
            ],
            scrollX: true,
            displayLength: 10,
            lengthChange: false,
            ordering: false,
            info: false,
          });
        });
      });
    </script>
  </body>
</html>
