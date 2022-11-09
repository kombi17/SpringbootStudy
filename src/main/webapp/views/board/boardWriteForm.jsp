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

                    <!-- summerNote -->
                    <link rel="stylesheet" href="\resources\lib\summernote\summernote-lite.min.css">
                    <script src="\resources\lib\summernote\summernote-lite.min.js"></script>
                    <script src="\resources\lib\summernote\lang\summernote-ko-KR.js"></script>

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
                                    <div class="main-container">
                                        <form action="/board/write" method="post">

                                            <div class="boardWrite">
                                                <input type="text" id="boardTitle" name="boardTitle"
                                                    placeholder="title">
                                            </div>

                                            <div class="boardWrite">
                                                <textarea name="boardContent" id="boardContent"></textarea>
                                            </div>

                                            <div class="btn-area">
                                                <button type="button" id="cancelBtn">취소</button>
                                                <button type="submit" id="boardWriteBtn">글쓰기</button>
                                                <!-- 수정일 경우 -->
                                            </div>


                                        </form>
                                    </div>


                            </div>
                    </main>
                    <!-- footer -->
                    <%@ include file="/views/common/footer.jsp" %>

                        <!-- boardWriteForm.js -->
                        <script src="\resources\js\board\boardWriteForm.js"></script>
                </body>

                </html>