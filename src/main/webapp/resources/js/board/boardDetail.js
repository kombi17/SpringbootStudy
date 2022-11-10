// 즉시 실행 함수 (delete 버튼이 존재하지 않을 경우도 있기 때문에)
// (function () {
//   const deleteBtn = document.getElementById("deleteBtn");

//   if (!deleteBtn) {
//     // 화면에 deleteBtn이 존재하는 경우
//     deleteBtn.addEventListener("click", function () {
//       console.log("삭제버튼클릭");
//       confirm("게시글을 삭제하시겠습니까?");
//       if (confirm) {
//         location.href = "../boardDelete/" + boardNo;
//         // 현재 : /board/boardDetail/{boardNo}
//         // 목표 : /board/boardDelete/{boardNo}
//       }
//     });
//   }
// })();

console.log(deleteBtn);

function deleteDetail() {
  const deleteBtn = document.getElementById("deleteBtn");
  if (!deleteBtn) {
    console.log("삭제");
    confirm("게시글을 삭제하시겠습니까?");
    if (confirm) {
      location.href = "../boardDetail/" + boardNo;
    }
  }
}
