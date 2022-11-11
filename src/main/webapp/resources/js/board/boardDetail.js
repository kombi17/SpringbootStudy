// 즉시 실행 함수 (delete 버튼이 존재하지 않을 경우도 있기 때문에)
(function () {
  const deleteBtn = document.getElementById("deleteBtn");

  if (deleteBtn) {
    // 화면에 deleteBtn이 존재하는 경우
    deleteBtn.addEventListener("click", function () {
      console.log("삭제버튼클릭");
      if (confirm("게시글을 삭제하시겠습니까?")) {
        location.href = "../boardDelete/" + boardNo;
        // 현재 : /board/boardDetail/{boardNo}
        // 목표 : /board/boardDelete/{boardNo}
      } else {
        location.replace("http://localhost:8080/board/boardDetail/" + boardNo);
      }
    });
  }
})();

const goToListBtn = document.getElementById("goToList");
goToListBtn.addEventListener("click", function () {
  location.href = "../boardList";
});

const modifyBtn = document.getElementById("modifyBtn");
modifyBtn.addEventListener("click", function () {
  location.href =
    "http://localhost:8080/board/boardWriteForm?mode=update&boardNo=" + boardNo;
});
