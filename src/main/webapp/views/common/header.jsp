<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
  href="https://fonts.googleapis.com/css2?family=Merriweather:ital,wght@1,900&family=Silkscreen&display=swap"
  rel="stylesheet"
/>
<link
  href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
  rel="stylesheet"
/>

<header class="header">
  <div id="title">
    <h1>
      <a href="/"><i class="fa-solid fa-book-open"></i> kombi assignment</a>
    </h1>
  </div>
  <div id="list">
    <nav>
      <ul id="header-list">
        <li class="header-menu">
          <a href="/"><i class="fa-solid fa-house"></i> Home</a>
        </li>
        <sec:authorize access="isAnonymous()">
          <li class="header-menu">
            <a href="/user/signUp"
              ><i class="fa-solid fa-user-plus"></i> Sign Up</a
            >
          </li>
          <li class="header-menu">
            <a href="/user/loginForm"
              ><i class="fa-solid fa-right-to-bracket"></i> Login</a
            >
          </li>
        </sec:authorize>
      </ul>
    </nav>
  </div>
</header>
