// 즉시 실행 함수 (delete 버튼이 존재하지 않을 경우도 있기 때문에)
(function () {
  const deleteBtn = document.getElementById("deleteBtn");

  if (deleteBtn != null) {
    deleteBtn.addEventListener("click", function () {
      confirm("게시글을 삭제하시겠습니까?");
      if (confirm) {
        location.href = "";
        // 현재 : /board/boardDetail/{boardNo}
        // 목표 : /board/boardDelete/{boardNo}
      } else {
        // 현재 페이지 머무르기
        location.href = "";
      }
    });
  }
});
