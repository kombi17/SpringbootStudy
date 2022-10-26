// userDetail 수정 유효성 검사
function infoValidate() {
  const userNickname = document.getElementById("userNickname");
  const userTel = document.getElementById("userTel");
  const userEmail = document.getElementById("userEmail");

  const nicknameRegExp = /^[a-zA-Z0-9가-힣]{2,10}$/; // 닉네임 정규식
  const telRegExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; // 전화번호 정규식
  const emailRegExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

  // 닉네임 유효성 검사
  if (userNickname.value.length == 0) {
    // 미작성 시 : 닉네임을 입력해주세요.
    return printAlert(userNickname, "닉네임을 입력해주세요.");
  }

  if (!nicknameRegExp.test(userNickname.value)) {
    // 유효하지 않은 경우
    return printAlert(
      userNickname,
      "닉네임은 영어/숫자/한글 2~10 글자 사이로 작성해주세요."
    );
  }

  // 이메일 유효성 검사
  if (userEmail.value.length == 0) {
    // 미작성 시
    return printAlert(userEmail, "이메일을 입력해주세요.");
  }

  if (!emailRegExp.test(userEmail.value)) {
    // 유효하지 않은 경우
    return printAlert(userEmail, "이메일 형식이 올바르지 않습니다.");
  }

  // 전화번호 유효성 검사
  if (userTel.value.length == 0) {
    // 미작성 시
    return printAlert(userTel, "전화번호를 입력해주세요.(- 제외)");
  }

  if (!telRegExp.test(userTel.value)) {
    // 유효하지 않은 경우

    return printAlert(userTel, "전화번호 형식이 올바르지 않습니다.");
  }

  return true; // true를 반환해서 form 제출 수행
}

function printAlert(el, message) {
  // 매개변수 el은 요소
  alert(message);
  el.focus();
  return false;
}

function shorResult() {
  alert(msg);
}

function sample4_execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var roadAddr = data.roadAddress; // 도로명 주소 변수

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      document.getElementById("sample4_postcode").value = data.zonecode;
      document.getElementById("sample4_roadAddress").value = roadAddr;
    },
  }).open();
}
