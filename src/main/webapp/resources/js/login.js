const error = document.getElementById("error");
const errorContent = document.getElementById("error").innerText;
const exception = document.getElementById("exception").innerText;

// console.log(errorContent);

if (error && errorContent != "") {
  // console.log(exception);
  alert("로그인 실패! " + exception);
}

// 입력 여부 유효성 확인
function inputValidate() {
  const inputId = document.getElementById("username");
  const inputPw = document.getElementById("password");

  if (inputId.value.trim().length == 0) {
    alert("아이디를 입력해주세요.");
    inputId.value = "";
    inputId.focus();
    return false;
  }

  if (inputPw.value.trim().length == 0) {
    alert("비밀번호를 입력해주세요.");
    inputPw.value = "";
    inputPw.focus();
    return false;
  }

  return true;
}
