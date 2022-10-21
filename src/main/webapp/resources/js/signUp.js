// 입력 여부 유효성 확인

// 유효성 검사 여부를 기록할 객체 생성
const checkObj = {
  inputId: false,
  inputPw: false,
  inputName: false,
  inputNickname: false,
  inputGenderList: false,
  inputHobbyList: false,
  inputEmail: false,
  inputTel: false,
  inputAddress: false,
  inputAddressDetail: false,
};

const inputId = document.getElementById("userId");
const inputPw = document.getElementById("userPw");
const inputName = document.getElementById("userName");
const inputNickname = document.getElementById("userNickname");
const inputGenderList = document.getElementsByName("userGender");
const inputHobbyList = document.getElementsByName("userHobby");
const inputEmail = document.getElementById("userEmail");
const inputTel = document.getElementById("userTel");

// api는 어떤 식으로 유효성 검사를 하남???????
const inputAddress = document.getElementById("userAddress");
const inputAddressDetail = document.getElementById("userAddressDetail");

let inputObj = [];

inputObj.push(inputId, inputPw, inputName, inputNickname);

for (let item in inputObj) {
  console.log(inputObj[item]);
  inputObj[item].addEventListener("input", function () {
    if (inputObj[item].value.length == 0) {
      switch (item) {
        case "inputId":
          checkObj.inputId = false;
          break;
        case "inputPw":
          checkObj.inputPw = false;
          break;
        case "inputName":
          checkObj.inputName = false;
          break;
        case "inputNickname":
          checkObj.inputNickname = false;
          break;
      }

      alert("채워지지 않은 입력칸이 있습니다.");
      document.getElementById(item).focus();
    }
  });
}

// 이메일 유효성 검사
inputEmail.addEventListener("input", function () {
  if (inputEmail.value.length == 0) {
    // 입력되지 않은 경우
    alert("이메일을 입력해주세요.");
    checkObj.inputEmail = false;
    return;
  }

  // 입력된 경우
  // 이메일 정규식
  const EmailRegExp = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/;

  if (EmailRegExp.test(inputEmail.value)) {
    // 유효한 경우
    // ajax 통해 중복 검사 (추후 추가)
    // $.ajax({
    //   url: "emailDupCheck",
    //   // 현재 주소 /user/signUp
    //   // 요청 주소 /user/emailDupCheck
    //   data: { inputEmail: inputEmail.value },
    //   type: "get",
    //   success: function (result) {
    //     // ajax가 오류 없이 요청/응답에 성공한 경우
    //     // result : 중복인 경우 1, 아닌 경우 0
    //     console.log(result);
    //     if (result > 0) {
    //       // 중복된 값인 경우
    //       alert("이미 사용 중인 이메일입니다.");
    //       checkObj.inputEmail = false;
    //     } else {
    //       // 중복되지 않은 경우
    //       checkObj.inputEmail = true;
    //     }
    //   },
    //   error: function () {
    //     // ajax 중 오류가 발생한 경우
    //     console.log("에러 발생");
    //   },
    // });
  } else {
    alert("유효하지 않은 이메일 주소입니다.");
    checkObj.inputEmail = false;
  }
});

// 전화번호 유효성 검사
inputTel.addEventListener("input", function () {
  // 입력이 되지 않은 경우
  if (inputTel.value.length == 0) {
    alert("전화번호를 입력해주세요.");
    checkObj.inputTel = false; // 유효하지 않은 상태임을 기록
    return;
  }

  // 전화번호 정규식
  const TelRegExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

  if (TelRegExp.test(inputTel.value)) {
    // 유효한 경우
    checkObj.inputTel = true; // 유효한 상태임을 기록
  } else {
    // 유효하지 않은 경우
    checkObj.inputTel = false; // 유효하지 않은 상태임을 기록
  }
});

// 성별 유효성 검사
for (let item in inputGenderList) {
  inputGenderList[item].addEventListener("click", function () {
    if (!inputGenderList[item].checked) {
      // 한 개도 체크되지 않은 경우
      alert("성별을 선택해주세요.");
      checkObj.inputGenderList = false;
    } else {
      // 하나라도 체크되어있는 경우
      checkObj.inputGenderList = true;
    }
  });
}

// 취미 유효성 검사
for (let item in inputHobbyList) {
  inputHobbyList[item].addEventListener("click", function () {
    if (!inputHobbyList[item].checked) {
      // 한 개도 체크되지 않은 경우
      alert("취미를 선택해주세요.");
      checkObj.inputHobbyList = false;
    } else {
      // 하나라도 체크되어있는 경우
      checkObj.inputHobbyList = true;
    }
  });
}

function signUpValidate() {
  // checkObj에 있는 모든 값에 접근해 false가 하나라도 있으면 form 제출 X

  let str;

  for (let key in checkObj) {
    if (!checkObj[key]) {
      switch (key) {
        case "inputId":
          str = "아이디를";
          break;
        case "inputPw":
          str = "비밀번호를";
          break;
        case "inputName":
          str = "이름을";
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
