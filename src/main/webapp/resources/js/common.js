/**
 * 로그아웃 전 경고창 위한 js
 */

const logoutBtn = document.getElementById("logout-btn");

logoutBtn.addEventListener("click", function () {
  alert("로그아웃 됩니다. Bye~");
});

// const goToListBtn = document.getElementById("goToList");
// if (goToListBtn != null) {
//   goToListBtn.addEventListener("click", function () {
//     const pathname = location.pathname;
//     // pathname : /user/detail/{userNo}

//     let url = pathname.substring(0, pathname.indexOf("/", 1));
//     // url : /user

//     url += "/list" + "?";
//     // /user/list?cp=1 모양 만들기 위해
//     // /user/list? 까지 만들고 cp 만들어서 조립

//     const params = new URL(location.href).searchParams;
//     // location.href : 'http://localhost:8080/user/list?cp=1'
//     // URL.searchParams : 쿼리 스트링을 별도 객체로 반환

//     let cp;

//     if (params.get("cp") != null) {
//       // 쿼리 스트링에 cp가 있을 경우
//       cp = "cp=" + params.get("cp");
//     } else {
//       cp = "cp=1";
//     }

//     // 조립
//     url += cp;

//     location.href = url;
//   });
// }
