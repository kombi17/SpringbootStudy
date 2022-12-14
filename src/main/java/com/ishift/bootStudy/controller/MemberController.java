package com.ishift.bootStudy.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ishift.bootStudy.model.vo.Member;
import com.ishift.bootStudy.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user") // controller가 많아질 때는 어느 컨트롤러인지 알 수 있도록
@RequiredArgsConstructor
public class MemberController {

  @Autowired
  MemberServiceImpl memberService;

  /**
   * 회원가입 폼
   * 
   * @return
   */
  @GetMapping("/signUpForm")
  public String signUpForm() {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null
        || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
      // 로그인 한 사용자가 없는 경우
      return "member/signUp";
    } else {
      // 로그인 한 사용자가 있는 경우
      return "redirect:/";
    }
  }

  /**
   * 회원가입 진행
   * 
   * @param registerUser, userAddress, userGender, userHobby
   * @return
   */
  @PostMapping("/signUp")
  public String signUp(Member member, String[] userAddress, String[] userHobby,
      RedirectAttributes ra) {

    int result = 0;

    try {
      // String[] userAddress, String[] userHobby
      // name이 userXXX인 파라미터의 값을 모두 배열에 담아서 반환
      // String.join("구분자", 배열) : 배열을 하나의 문자로 합치는 메서드

      member.setUserAddress(String.join(",,", userAddress));
      member.setUserHobby(String.join(",,", userHobby));

      // 성별과 취미는 유효성 검사 있지만 주소는 없으므로 컨트롤러에서 처리
      if (member.getUserAddress().equals(",,,,")) {
        // 주소 입력 X
        member.setUserAddress("no Address");
      }

      // 회원 가입
      result = memberService.signUp(member);

      if (result > 0) {
        ra.addFlashAttribute("message", "회원가입이 완료되었습니다.");
      } else {
        ra.addFlashAttribute("message", "회원 가입 실패!");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/";
  }

  /**
   * 아이디 중복 체크
   * 
   * @param inputId
   * @return
   */
  @ResponseBody
  @GetMapping("/idDupCheck")
  public int idDupCheck(String inputId) {
    System.out.println(inputId);
    return memberService.idDupCheck(inputId);
  }

  /**
   * 로그인 페이지로 이동
   * 
   * @return
   */
  @GetMapping("/loginForm")
  public String loginForm(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "exception", required = false) String exception, Model model) {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if (authentication == null
        || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
      // 로그인 한 사람이 없는 경우

      // error, exception을 모델에 담아 view로
      if (error != null) { // 로그인 실패의 경우
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "member/loginPage";
      } else {
        // 로그인 성공의 경우
        return "member/loginPage";
      }

    } else {
      // 로그인 한 사람이 있는 경우
      return "redirect:/";
    }
  }


  /**
   * 회원 정보 수정 form으로 이동
   */
  @GetMapping("/detail/{userId}")
  public String userDetailFormNew(@PathVariable("userId") String userId, Principal principal,
      Model model, RedirectAttributes ra) throws Exception {

    // 로그인 한 회원 1명의 정보
    try {

      System.out.println(userId);

      String loginId = principal.getName();

      System.out.println(loginId);

      Member loginUser = memberService.selectLoginUser(loginId);

      if (userId.equals(loginId)) {
        // 로그인 한 유저와 클릭한 유저가 같을 경우
        model.addAttribute("loginuser", loginUser);
        return "member/userDetail";
      } else {
        ra.addFlashAttribute("message", loginId + " 님의 정보만 수정이 가능합니다.");
      }


    } catch (Exception e) {
      e.printStackTrace();
    }

    return "redirect:/user/memberList";
  }

  /**
   * 회원정보 수정 진행
   * 
   * @param user
   * @return
   */
  @PostMapping("/detail/update")
  public String userUpdate(String[] updateUserAddress, String[] updateUserHobby,
      Principal principal, @RequestParam Map<String, Object> paramMap, RedirectAttributes ra) {

    // PUT 요청 : 리소스를 생성 및 업데이트 하기 위해 서버로 데이터를 보낼 때 쓰는 방법
    // post와 put의 차이 : put 요청은 멱등성 유지, 동일한 put 요청을 여러 번 호출해도 항상 동일한 결과 생성
    // 멱등성 : 여러 번 수행해도 결과가 같은 성질, 호출로 인해 데이터가 변경되지 않는다.
    // 일단은 post 요청으로 기능 구현

    // @RequestParam("name속성값") 자료형 변수명 : 클라이언트 요청시 같이 전달된 파라미터를 변수에 저장
    // name 속성 값을 이용해 지정!! name속성값과 파라미터를 저장할 변수 이름을 동일하게 작성하면 어노테이션 생략 가능

    // @RequestParam Map<String, Object> paramMap
    // 요청 시 전달된 파라미터를 구분하지 않고 모두 map에 담아서 얻어옴
    // name 속성 값이 map의 key

    // 필요한 값 : paramMap에 들어있음(닉네임, 이메일, 전화번호) // 주소, userNo(principal 통해서 받기)
    String userId = principal.getName();

    int userNo = memberService.selectLoginUser(userId).getUserNo();

    // 주소 배열을 String으로 변경
    String userAddress = String.join(",,", updateUserAddress);

    if (userAddress.equals(",,,,"))
      userAddress = "no Address";

    // 취미 배열을 String으로 변경
    String userHobby = String.join(",,", updateUserHobby);

    paramMap.put("userNo", userNo);
    paramMap.put("userAddress", userAddress);
    paramMap.put("userHobby", userHobby);

    int result = memberService.userUpdate(paramMap);

    String msg = null;

    if (result > 0) {
      msg = "회원 정보가 수정되었습니다.";

    } else {
      msg = "회원 정보 수정 실패";
    }

    ra.addFlashAttribute("message", msg);

    return "redirect:/user/memberList";
  }



  @GetMapping("/memberList")
  public String memberList() {
    return "member/memberList";
  }


  @ResponseBody
  @GetMapping("/selectMemberList")
  public List<Member> selectMemberList(@RequestParam Map<String, Object> paramMap,
      String[] searchHobby) {

    List<Member> memberList = new ArrayList<Member>();

    // startDate와 endDate를 비교해서 더 우선인 날짜가 앞에 배치되도록 하면 좋을 것 같은데!!!
    if (!paramMap.get("startDate").equals("") && !paramMap.get("endDate").equals("")) {
      // startDate와 endDate가 빈 칸이 아닐 경우

      // object를 String으로 변환
      String startDate = (String) paramMap.get("startDate");
      String endDate = (String) paramMap.get("endDate");

      // 날짜 비교용 변수 선언
      int result = 0;

      // formatter
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

      // String으로 변환한 날짜를 비교를 위해 LocalDate로 변환
      LocalDate parseStartDate = LocalDate.parse(startDate, formatter);
      LocalDate parseEndDate = LocalDate.parse(endDate, formatter);

      // 날짜 비교
      result = parseStartDate.compareTo(parseEndDate); // startDate가 이전일 경우 -1, 같을 경우 0, 이후일 경우 1

      if (result > 0) {
        // startDate이 endDate보다 이후인 경우

        // LocalDate를 String으로 변환한 후 이전 날짜를 startDate에 대입
        startDate = parseEndDate.format(formatter);
        endDate = parseStartDate.format(formatter);

        // paramMap에 넣기
        paramMap.put("startDate", startDate);
        paramMap.put("endDate", endDate);
      }
    }

    if (paramMap.containsKey("searchHobby")) {

      String userHobby = String.join(",,", searchHobby);

      paramMap.put("userHobby", userHobby);
    }

    memberList = memberService.selectMemberList(paramMap);

    return memberList;
  }

  /**
   * 회원 탈퇴로 이동
   * 
   * @return
   */
  @GetMapping("/memberSecession")
  public String secessionForm(Principal principal, Model model) {

    String loginUserId = principal.getName();

    Member loginUser = memberService.selectLoginUser(loginUserId);

    model.addAttribute("loginuser", loginUser);

    return "member/memberSecession";
  }

  @GetMapping("/checkPw")
  public String checkPw() {
    return "member/checkPw";
  }

  @PostMapping("/memberSecession")
  public String memberSecession(Principal principal, String userPw, RedirectAttributes ra) {

    // 로그인한 회원의 비밀번호
    String loginUserPw = memberService.selectLoginUser(principal.getName()).getUserPw();
    
    // 로그인 한 회원의 회원 번호
    int userNo = memberService.selectLoginUser(principal.getName()).getUserNo();

    // bcrypt를 이용한 비밀번호 암호화
    BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

    String msg = "";
    String path = "";

    if (bcrypt.matches(userPw, loginUserPw)) {
      // 입력한 비밀번호와 로그인 한 유저의 비밀번호가 같은 경우

      // 회원 탈퇴 (서비스 구현)
      int result = memberService.memberSecession(userNo);

      if (result > 0) {
        msg = "회원 탈퇴에 성공했습니다. 다시 만날 수 있길 바랍니다.";
        path = "redirect:/user/loginForm";
        // 탈퇴 회원은 접근 못 하도록 (세션 종료 및 로그인 안 되도록)
        SecurityContextHolder.clearContext();
        // 근데 이거 로그아웃이 안 되는 것 같음... security 통해서 로그인하면 자동으로 세션으로 올라가는지 추후 확인해볼 것

      } else {
        msg = "회원 탈퇴에 실패했습니다. 관리자에게 문의해주세요.";
        path = "redirect:/user/memberSecession";
      }

    } else {
      System.out.println("비밀번호 불일치");
      msg = "비밀번호가 일치하지 않습니다.";
      path = "redirect:/user/memberSecession";
    }


    ra.addFlashAttribute("message", msg);
    return path;

  }

}

