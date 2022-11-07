<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
                                            <h1>회원 탈퇴</h1>
                                            <hr>
                                            <div class="input-content">
                                                아이디 : ${loginuser.userId}
                                            </div>
                                            <div class="input-content">
                                                이름 : ${loginuser.userName}
                                            </div>
                                            <div class="input-content">
                                                닉네임 : ${loginuser.userNickname}
                                            </div>
                                            <div class="input-content">
                                                이메일 : ${loginuser.userEmail}
                                            </div>
                                            <div class="blank"></div>
                                            <div class="secession-guide">
                                                <ul>
                                                    <li class="secession-guide-detail">이 계정의 회원정보 및 서비스 이용기록이 삭제됩니다.
                                                    </li>
                                                    <li class="secession-guide-detail">향후 계정 정보나 이용 내역을 확인할 수 없습니다.
                                                    </li>
                                                    <li class="secession-guide-detail">계정 삭제 후에는 복구가 불가능합니다.</li>
                                                    <li class="secession-guide-detail">개인 정보와 위 안내를 확인하신 후 탈퇴를
                                                        진행해주세요.</li>
                                                </ul>
                                            </div>

                                            <div class="blank"></div>
                                            <div id="chkbox">
                                                <input type="checkbox" id="secession-agree">
                                                <label for="secession-agree">모두 확인했습니다.</label>
                                            </div>

                                            <button type="submit" class="submit-btn"
                                                onclick="return secessionValidate()"> 회원 탈퇴
                                            </button>
                                        </div>
                                    </div>
                            </div>
                    </main>

                    <%@ include file="/views/common/footer.jsp" %>

                        <!-- js -->
                        <script src="/resources/js/secession.js" />
                        </script>

                </body>

                </html>