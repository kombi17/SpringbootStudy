$("#boardContent").summernote({
  height: 300, // 에디터 높이
  minHeight: null, // 최소 높이
  maxHeight: null, // 최대 높이
  focus: true, // 에디터 로딩후 포커스를 맞출지 여부
  lang: "ko-KR", // 한글 설정
  toolbar: [
    ["fontname", ["fontname"]],
    ["fontsize", ["fontsize"]],
    ["style", ["bold", "italic", "underline"]],
    ["color", ["forecolor", "color"]],
    ["para", ["ul", "ol", "paragraph"]],
    ["height", ["height"]],
    ["insert", ["picture"]],
  ],
  fontNames: [
    "Arial",
    "Arial Black",
    "Comic Sans MS",
    "Courier New",
    "맑은 고딕",
    "돋움체",
    "바탕체",
    "sans-serif",
  ],
  fontSizes: [
    "8",
    "9",
    "10",
    "11",
    "12",
    "14",
    "16",
    "18",
    "20",
    "22",
    "24",
    "28",
    "30",
    "36",
    "50",
    "72",
  ],
});

document.getElementById("cancelBtn").addEventListener("click", function () {
  location.href = "http://localhost:8080/board/boardList";
});

function boardValidate() {
  const boardTitle = document.getElementById("boardTitle");
  const boardContent = document.getElementById("boardContent");

  if (boardTitle.value.length != 0 && boardContent.value.length != 0) {
    return false;
  }

  if (boardTitle.value.length == 0) {
    console.log("제목 빈칸");
    return printAlert(boardTitle, "제목을 입력해주세요.");
  }

  if (boardContent.value.length == 0) {
    console.log("내용 빈칸");
    return printAlert(boardContent, "내용을 입력해주세요.");
  }
}

function printAlert(el, message) {
  // 매개변수 el은 요소
  alert(message);
  el.focus();
  return false;
}
