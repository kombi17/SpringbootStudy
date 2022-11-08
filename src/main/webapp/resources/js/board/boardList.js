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
          render: function (data, type, row) {
            data =
              "<a class='boardTitle' href=/board/boardDetail/" +
              row.boardNo +
              ">" +
              data +
              "</a>";
            return data;
          },
        },
        {
          data: "userId",
          render: function (data, type, row) {
            return row.userId + " (" + row.userNickname + ")";
          },
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
      columnDefs: [
        { targets: [0, 3, 6], visible: false },
        { targets: 1, width: 400 },
      ],
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
