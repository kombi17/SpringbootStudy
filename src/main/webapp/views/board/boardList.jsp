<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
            <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

                <!DOCTYPE html>
                <html lang="en">

                <head>
                    <meta charset="UTF-8">
                    <meta http-equiv="X-UA-Compatible" content="IE=edge">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">

                    <link rel="stylesheet" href="/resources/css/common.css" />

                    <script src="https://kit.fontawesome.com/245c493145.js" crossorigin="anonymous"></script>

                    <!-- jQuery -->
                    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
                    <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />
                    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.min.js"></script>

                    <!-- dataTable -->
                    <link rel="stylesheet" type="text/css"
                        href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
                    <script type="text/javascript"
                        src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>


                    <title>BoardList</title>
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
                                        <!-- search Area -->


                                        <div class="list-container">
                                            <table id="boardList" class="display nowrap">
                                                <thead>
                                                    <tr>
                                                        <th class="title">No</th>
                                                        <th class="title">제목</th>
                                                        <th class="title">아이디</th>
                                                        <th class="title">닉네임</th>
                                                        <th class="title">작성 날짜</th>
                                                        <th class="title">조회수</th>
                                                        <th class="title">userNo</th>
                                                    </tr>
                                                </thead>
                                            </table>
                                        </div>
                                    </div>
                            </div>


                    </main>
                    <!-- footer -->
                    <%@ include file="/views/common/footer.jsp" %>

                        <!-- boardList.js -->
                        <script src="/resources/js/board/boardList.js"></script>

                </body>

                </html>