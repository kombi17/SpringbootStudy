// 입력 여부 유효성 확인

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
  inputId: false,
  inputPw: false,
  inputNickname: false,
  inputGenderList: false,
  inputHobbyList: false,
  inputEmail: false,
  inputTel: false,
};

// const inputAddress = document.getElementsByName("userAddress");

// 아이디 빈칸 검사
const inputId = document.getElementById("userId");
const idMsg = document.getElementById("idMsg");

inputId.addEventListener("input", function () {
  if (inputId.value.length == 0) {
    // 입력되지 않은 경우
    idMsg.innerText = "영어, 숫자 6-20자 사이로 작성해주세요.";
    idMsg.classList.remove("confirm", "error");

    checkObj.inputId = false;
    return;
  }

  // 입력된 경우
  const idRegExp = /^[a-z0-9]{6,20}$/g;
  if (idRegExp.test(inputId.value)) {
    // 유효한 경우
    idMsg.innerText = "사용 가능한 아이디 입니다.";
    idMsg.classList.add("confirm");
    idMsg.classList.remove("error");
    checkObj.inputId = true;

    // 아이디 중복 체크 하면 좋을 것 같음!! ajax 이용?
  } else {
    // 유효하지 않은 경우
    idMsg.innerText = "적합하지 않은 아이디입니다.";
    idMsg.classList.add("error");
    idMsg.classList.remove("confirm");
    checkObj.inputId = false;
  }
});

// 비밀번호 유효성 검사
const inputPw = document.getElementById("userPw");
const pwMsg = document.getElementById("pwMsg");
inputPw.addEventListener("input", function () {
  if (inputPw.value.length == 0) {
    // 입력되지 않은 경우
    pwMsg.innerText =
      "영어, 숫자, 특수문자(!,@,#,-,_) 6~30글자 사이로 작성해주세요.";
    pwMsg.classList.remove("confirm", "error");

    checkObj.inputPw = false;
    return;
  }

  // 입력된 경우
  const pwRegExp = /^[\w!@#_-]{6,30}$/;
  if (pwRegExp.test(inputPw.value)) {
    // 유효한 경우
    pwMsg.innerText = "사용 가능한 비밀번호 입니다.";
    pwMsg.classList.add("confirm");
    pwMsg.classList.remove("error");
    checkObj.inputPw = true;

    // 아이디 중복 체크 하면 좋을 것 같음!! ajax 이용?
  } else {
    // 유효하지 않은 경우
    pwMsg.innerText = "적합하지 않은 비밀번호입니다.";
    pwMsg.classList.add("error");
    pwMsg.classList.remove("confirm");
    checkObj.inputPw = false;
  }
});

// 닉네임 유효성 검사
const inputNickname = document.getElementById("userNickname");
const nicknameMsg = document.getElementById("nicknameMsg");
inputNickname.addEventListener("input", function () {
  if (inputNickname.value.length == 0) {
    // 입력되지 않은 경우
    nicknameMsg.innerText = "영어, 숫자, 한글 2~10자 사이로 작성해주세요.";
    nicknameMsg.classList.remove("confirm", "error");

    checkObj.inputNickname = false;
    return;
  }

  // 입력된 경우
  const nicknameRegExp = /^[a-zA-Z0-9가-힣]{2,10}$/;
  if (nicknameRegExp.test(inputNickname.value)) {
    // 유효한 경우
    nicknameMsg.innerText = "사용 가능한 닉네임 입니다.";
    nicknameMsg.classList.add("confirm");
    nicknameMsg.classList.remove("error");
    checkObj.inputNickname = true;
  } else {
    // 유효하지 않은 경우
    nicknameMsg.innerText = "적합하지 않은 닉네임입니다.";
    nicknameMsg.classList.add("error");
    nicknameMsg.classList.remove("confirm");
    checkObj.inputNickname = false;
  }
});

// 이메일 유효성 검사
const inputEmail = document.getElementById("userEmail");
const emailMsg = document.getElementById("emailMsg");
inputEmail.addEventListener("input", function () {
  if (inputEmail.value.length == 0) {
    // 입력되지 않은 경우
    emailMsg.innerText = "메일을 받을 수 있는 이메일을 입력해주세요.";
    emailMsg.classList.remove("confirm", "error");
    checkObj.inputEmail = false;
    return;
  }

  // 입력된 경우
  // 이메일 정규식
  const emailRegExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

  if (emailRegExp.test(inputEmail.value)) {
    // 유효한 경우
    emailMsg.innerText = "사용 가능한 이메일 입니다.";
    emailMsg.classList.add("confirm");
    emailMsg.classList.remove("error");
    checkObj.inputEmail = true;
  } else {
    emailMsg.innerText = "적합하지 않은 이메일입니다.";
    emailMsg.classList.add("error");
    emailMsg.classList.remove("confirm");
    checkObj.inputEmail = false;
  }
});

// 전화번호 유효성 검사
const inputTel = document.getElementById("userTel");
const telMsg = document.getElementById("telMsg");
inputTel.addEventListener("input", function () {
  // 입력이 되지 않은 경우
  if (inputTel.value.length == 0) {
    // 입력되지 않은 경우
    telMsg.innerText = "전화번호를 입력해주세요.(- 제외)";
    telMsg.classList.remove("confirm", "error");
    checkObj.inputTel = false;
    return;
  }

  // 입력된 경우
  // 전화번호 정규식
  const telRegExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

  if (telRegExp.test(inputTel.value)) {
    // 유효한 경우
    telMsg.innerText = "사용 가능한 이메일 입니다.";
    telMsg.classList.add("confirm");
    telMsg.classList.remove("error");
    checkObj.inputTel = true;
  } else {
    telMsg.innerText = "적합하지 않은 이메일입니다.";
    telMsg.classList.add("error");
    telMsg.classList.remove("confirm");
    checkObj.inputTel = false;
  }
});

// 성별 유효성 검사
const inputGenderList = document.getElementsByName("userGender");
const genderCheck = inputGenderList.values.length;
const genderMsg = document.getElementById("genderMsg");

for (var i = 0; i < inputGenderList.length; i++) {
  inputGenderList[i].addEventListener("change", function (e) {
    if (e.target.checked) {
      genderMsg.innerText = "선택되었습니다.";
      genderMsg.classList.add("confirm");
      genderMsg.classList.remove("error");
      checkObj.inputGenderList = true;
    } else {
      genderMsg.innerHTML = "성별을 선택해주세요.";
      genderMsg.classList.add("error");
      genderMsg.classList.remove("confirm");
      checkObj.inputGenderList = false;
    }
  });
}

// done!! 기쁘다!!ㅠㅠ
const inputHobbyList = document.getElementsByName("userHobby");
const hobbyMsg = document.getElementById("hobbyMsg");
var count = 0;
for (var i = 0; i < inputHobbyList.length; i++) {
  if (inputHobbyList[i].checked) {
    // 첫 번째 클릭
    count++;
  }

  inputHobbyList[i].addEventListener("change", function (e) {
    if (e.target.checked) {
      // 선택하면 +1
      count += 1;
    } else {
      // 선택 취소하면 -1
      count -= 1;
    }

    if (count == 0) {
      // 한 가지도 선택하지 않았을 때
      hobbyMsg.innerHTML = "취미를 선택해주세요.";
      hobbyMsg.classList.add("error");
      hobbyMsg.classList.remove("confirm");
      checkObj.inputHobbyList = false;
    } else {
      hobbyMsg.innerText = "선택되었습니다.";
      hobbyMsg.classList.add("confirm");
      hobbyMsg.classList.remove("error");
      checkObj.inputHobbyList = true;
    }
  });
}

function signUpValidate() {
  // checkObj에 있는 모든 값에 접근해 false가 하나라도 있으면 form 제출 X

  let str;

  for (let key in checkObj) {
    if (checkObj[key] === false) {
      switch (key) {
        case "inputId":
          str = "아이디를";
          break;
        case "inputPw":
          str = "비밀번호를";
          break;
        case "inputNickname":
          str = "닉네임을";
          break;
        case "inputEmail":
          str = "이메일을";
          break;
        case "inputTel":
          str = "전화번호를";
          break;
        case "inputGenderList":
          str = "성별을";
          break;
        case "inputHobbyList":
          str = "취미를";
          break;
      }
      str += " 다시 확인해주세요.";

      alert(str);
      document.getElementById(key).focus();
      return false;
    }
  }

  return false;
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
