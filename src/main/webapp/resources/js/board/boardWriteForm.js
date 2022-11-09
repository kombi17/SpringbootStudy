$("#boardContent").summernote({
  height: 150,
  lang: "ko-KR",
});

document.getElementById("cancelBtn").addEventListener("click", function () {
  location.replace("http://localhost:8080/board/boardList");
});
