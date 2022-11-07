function selectBoardList() {
  // 검색 관련 내용 추후 추가

  $.ajax({
    url: "selectBoardList",
    // data: searchContent,
  }).done(function (data) {
    var table = $("#boardList").DataTable({
      destroy: true,
      data: data,
      dataSrc: "",
      columns: [
        {
          data: "boardNo",
        },
        {
          data: "boardTitle",
        },
        {
          data: "userId",
        },
        {
          data: "userNickname",
        },
        {
          data: "createDate",
        },
        {
          data: "readCount",
        },
        {
          data: "userNo",
        },
      ],
      //   columnDefs: [{ targets: 7, visible: false }],
      scrollX: true,
      displayLength: 10,
      lengthChange: false,
      ordering: false,
      info: false,
      searching: false,
      pageLength: 10,
      language: {
        emptyTable: "결과가 없습니다.",
        infoEmpty: "결과가 없습니다.",
        paginate: {
          next: "다음",
          previous: "이전",
        },
      },
      dom: "iltfp",
    });
  });
}

$(document).ready(function () {
  selectBoardList();
});
