<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,900&family=Silkscreen&display=swap"
  rel="stylesheet"
/>

<div id="sidebar">
  <div id="sidebar-list">
    <div id="sidebar-title">
      <a href="/"><i class="fa-solid fa-book-open"></i> kombi asgmt</a>
    </div>
    <sec:authorize access="isAuthenticated()">
      <div class="sidebar-menu">
        <a href="/user/list"
          ><i class="fa-regular fa-rectangle-list"></i> User List</a
        >
      </div>
      <div class="sidebar-menu">
        <a href="/user/checkPwForm"
          ><i class="fa-solid fa-key"></i> Change Pw</a
        >
      </div>
      <div class="sidebar-menu">
        <a href="/user/checkPwForm"><i class="fa-solid fa-user"></i> My Info</a>
      </div>
      <div class="sidebar-menu">
        <a href="/logout" id="logout-btn"
          ><i class="fa-regular fa-circle-xmark"></i> logout</a
        >
      </div>
    </sec:authorize>
  </div>
</div>
