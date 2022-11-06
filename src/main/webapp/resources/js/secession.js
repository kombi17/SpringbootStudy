const secessionAgree = document.getElementById("secession-agree");

function secessionValidate() {
  if (!secessionAgree.checked) {
    // 체크박스에 체크가 되어있지 않으면
    alert("약관 동의 후 탈퇴 버튼을 클릭해주세요.");
    return false;
  } else {
    // 체크박스 체크 O
    if (confirm("정말 탈퇴하시겠습니까?")) {
      // jsp 파일로 넘어가면 안 되고 uri 로 넘어가야 함!! getmapping? ajax?
      location.replace("http://localhost:8080/user/checkPw");

      return true;
    } else {
      return false;
    }
  }
}
