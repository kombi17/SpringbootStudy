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
          <link rel="stylesheet" href="../resources/css/common.css" />
          <link rel="stylesheet" href="../resources/css/memberList-style.css" />
          <script src="https://kit.fontawesome.com/245c493145.js" crossorigin="anonymous"></script>

          <!-- jQuery -->
          <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
          <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
          <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>

          <!-- dataTable -->
          <link rel="stylesheet" type="text/css"
            href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
          <script type="text/javascript" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>

          <title>asgmt</title>
        </head>

        <body>
          <main>
            <!-- header -->
            <%@ include file="/views/common/header.jsp" %>
              <div class="content">
                <!-- sidebar -->
                <%@ include file="/views/common/sidebar.jsp" %>
                  <div id="searchArea">
                    <form id="searchContent" autocomplete="off">
                      <!-- 기간 -->
                      <!-- datepicker 사용 -->
                      <div>
                        <input type="text" id="startDate" name="startDate" />
                        <input type="text" id="endDate" name="endDate" />
                      </div>

                      <!-- 성별 -->
                      <div>
                        <label for="male">남성</label>
                        <input type="radio" name="searchGender" id="male" value="male" />
                        <label for="female">여성</label>
                        <input type="radio" name="searchGender" id="female" value="female" />
                        <label for="noSelect">선택 안 함</label>
                        <input type="radio" name="searchGender" id="noSelect" value="noSelect" />
                      </div>
                      <!-- 취미 -->
                      <div>
                        <label for="book">독서</label>
                        <input type="checkbox" name="searchHobby" id="book" value="book" />

                        <label for="music">음악 감상</label>
                        <input type="checkbox" name="searchHobby" id="music" value="music" />

                        <label for="movie">영화 감상</label>
                        <input type="checkbox" name="searchHobby" id="movie" value="movie" />

                        <label for="knitting">뜨개질</label>
                        <input type="checkbox" name="searchHobby" id="knitting" value="knitting" />

                        <label for="baking">베이킹</label>
                        <input type="checkbox" name="searchHobby" id="baking" value="baking" />
                      </div>
                      <!-- 아이디, 이름, 닉네임 & 검색어 -->
                      <div>
                        <select name="searchKey" id="searchKey">
                          <option value="" selected>=== 선택 ===</option>
                          <option value="id">아이디</option>
                          <option value="name">이름</option>
                          <option value="nickname">닉네임</option>
                        </select>
                        <input type="text" name="searchQuery" id="searchQuery" />
                      </div>
                      <div>
                        <button type="button" id="searchSubmit" onclick="selectMemberList()">검색</button>
                      </div>
                    </form>
                  </div>

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
                $("#startDate, #endDate").datepicker({
                  dateFormat: "yy-mm-dd", //달력 날짜 형태
                  showOtherMonths: true, //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                  showMonthAfterYear: true, // 월- 년 순서가아닌 년도 - 월 순서
                  changeYear: true, //option값 년 선택 가능
                  changeMonth: true, //option값  월 선택 가능
                  showOn: "both", //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시
                  buttonImage:
                    "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif", //버튼 이미지 경로
                  buttonImageOnly: true, //버튼 이미지만 깔끔하게 보이게함
                  buttonText: "선택", //버튼 호버 텍스트
                  yearSuffix: "년", //달력의 년도 부분 뒤 텍스트
                  monthNamesShort: [
                    "1월",
                    "2월",
                    "3월",
                    "4월",
                    "5월",
                    "6월",
                    "7월",
                    "8월",
                    "9월",
                    "10월",
                    "11월",
                    "12월",
                  ], //달력의 월 부분 텍스트
                  monthNames: [
                    "1월",
                    "2월",
                    "3월",
                    "4월",
                    "5월",
                    "6월",
                    "7월",
                    "8월",
                    "9월",
                    "10월",
                    "11월",
                    "12월",
                  ], //달력의 월 부분 Tooltip
                  dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"], //달력의 요일 텍스트
                  dayNames: [
                    "일요일",
                    "월요일",
                    "화요일",
                    "수요일",
                    "목요일",
                    "금요일",
                    "토요일",
                  ], //달력의 요일 Tooltip
                  minDate: "-5Y", //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                  maxDate: "+5y", //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
                });

                // 초기값 설정
                // $("#startDate, #endDate").datepicker("setDate", "today"); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
              });

              // var searchContent = $("#searchContent").serializeArray();
              // for (let i in searchContent) {

              //   var value = searchContent[i].value;

              //   console.log(i);
              //   console.log(searchContent[i]);
              //   console.log("name : " + searchContent[i].name);
              //   console.log("value : " + value);

              //   // 기간



              //   // 성별
              //   // 취미
              //   // 아이디, 이름, 닉네임 검색어


              // }

              function selectMemberList() {
                var searchContent = $("#searchContent").serialize();
                console.log(searchContent);

                $.ajax({
                  url: "selectMemberList",
                  data: searchContent,
                }).done(function (data) {
                  var table = $("#memberList").DataTable({
                    destroy: true,
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
              };

              $(document).ready(function () {
                selectMemberList();
              })

            </script>
        </body>

        </html>