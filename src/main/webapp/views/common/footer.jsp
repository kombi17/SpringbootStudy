<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>

<footer>
  <p>Copyright &copy; KEB Assignment</p>

  <article>
    <a href="#">A</a>
    <span>|</span>
    <a href="#">B</a>
    <span>|</span>
    <a href="#">C</a>
    <span>|</span>
    <a href="#">D</a>
  </article>
</footer>

<!-- request에 message속성이 존재하면 alert창으로 해당 내용 출력 -->
<c:if test="${ !empty message }">
  <script>
    alert("${message}");
    // EL 작성 시 scope를 지정하지 않으면
    // page -> request -> session -> application 순서로 검색하여
    // 일치하는 속성이 있으면 출력
  </script>
</c:if>
