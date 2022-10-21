// 입력 여부 유효성 확인

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
  userId: false,
  userPw: false,
  userName: false,
  userNickname: false,
  userGender: false,
  userHobby: false,
  userEmail: false,
  userTel: false,
  userAddress: false,
  userAddressDetail: false,
};

function inputValidate() {
  const inputId = document.getElementById("userId");
  const inputPw = document.getElementById("userPw");
  const inputName = document.getElementById("userName");
  const inputNickname = document.getElementById("userNickname");
  const inputGender = document.getElementsByName("userGender");
  const inputHobby = document.getElementsByName("userHobby");
  const inputEmail = document.getElementById("userEmail");
  const inputTel = document.getElementById("userTel");

  // api는 어떤 식으로 유효성 검사를 하남???????
  const inputAddress = document.getElementById("userAddress");
  const inputAddressDetail = document.getElementById("userAddressDetail");

  // input 유효성 검사
  var inputObj = [];

  inputObj.push(
    inputId,
    inputPw,
    inputName,
    inputNickname,
    inputEmail,
    inputTel,
    inputAddressDetail
  );

  for (let inputObjContent of inputObj) {
    if (inputObjContent.value.trim().length == 0) {
      alert("입력되지 않은 항목이 있습니다.");
      inputObjContent.value = "";
      inputObjContent.focus();
      return false;
    } else {
      // 어떤 값이 입력이 되긴 했음!!
      // 성별 유효성 검사
      for (var i = 0; i < inputGender.length; i++) {
        if (!inputGender[i].checked) {
          alert("성별을 선택해주세요.");
          return false;
        }
      }

      // 취미 유효성 검사
      for (var i = 0; i < inputHobby.length; i++) {
        if (!inputHobby[i].checked) {
          alert("취미를 선택해주세요.");
          return false;
        }
      }
    }
  }

  // 이메일 정규식
  const EmailRegExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

  // 전화번호 정규식
  const TelRegExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

  if (!EmailRegExp.test(inputEmail.value)) {
    alert("유효하지 않은 이메일 주소입니다.");
    return false;
  }

  if (!TelRegExp.test(inputTel.value)) {
    alert("유효하지 않은 전화번호입니다.");
    return false;
  }

  return true;
}
