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

                  <!-- main-content -->
                  <div id="list-content">

                    <div id="searchArea">
                      <form id="searchContent" autocomplete="off">
                        <!-- 기간 -->
                        <!-- datepicker 사용 -->
                        <div class="search-detail" id="dateSearch">
                          <input type="text" id="startDate" name="startDate" />
                          <span> ~ </span>
                          <input type="text" id="endDate" name="endDate" />
                        </div>

                        <!-- 성별 -->
                        <div class="search-detail" id="genderSearch">
                          <label for="male">남성</label>
                          <input type="radio" name="searchGender" id="male" value="male" />
                          <label for="female">여성</label>
                          <input type="radio" name="searchGender" id="female" value="female" />
                          <label for="noSelect">선택 안 함</label>
                          <input type="radio" name="searchGender" id="noSelect" value="noSelect" />
                        </div>
                        <!-- 취미 -->
                        <div class="search-detail" id="hobbySearch">
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
                        <div class="search-detail" id="querySearch">
                          <select name="searchKey" id="searchKey">
                            <option value="" selected>=== 선택 ===</option>
                            <option value="id">아이디</option>
                            <option value="name">이름</option>
                            <option value="nickname">닉네임</option>
                          </select>
                          <input type="text" name="searchQuery" id="searchQuery" />
                        </div>
                        <div class="search-detail" id="searchBtnArea">
                          <button type="button" id="searchSubmit" onclick="selectMemberList()">검색</button>
                        </div>
                      </form>
                    </div>

                    <!-- 리스트 -->
                    <div class="list-container">
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
                      </table>
                    </div>
                  </div>
              </div>
          </main>

          <!-- footer -->
          <%@ include file="../views/common/footer.jsp" %>

            <!-- memberList.js -->
            <script src="..\resources\js\memberList.js"></script>

        </body>

        </html>