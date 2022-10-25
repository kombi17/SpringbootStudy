package com.ishift.bootStudy.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ishift.bootStudy.model.vo.RegisterUser;
import com.ishift.bootStudy.model.vo.User;
import com.ishift.bootStudy.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user") // controller가 많아질 때는 어느 컨트롤러인지 알 수 있도록
@RequiredArgsConstructor
public class UserController {
	
    @Autowired
    UserServiceImpl userService;

    /**
     * 회원가입 폼
     * @return
     */
    @GetMapping("/signUp")
    public String signUpForm() {
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
    		// 로그인 한 사용자가 없는 경우
    		return "signUp";
    	} else {
    		// 로그인 한 사용자가 있는 경우
    		return "redirect:/";
    	}
    }

    /**
     * 회원가입 진행
     * @param user
     * @return
     */
    @PostMapping("/signUp")
    public String signUp(RegisterUser registerUser) {
    	try {
            userService.signUp(registerUser);
            
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
        return "redirect:/user/loginForm"; 
    }
    
    /**
     * 이메일 중복 체크
     * @param inputEmail
     * @return
     */
    @ResponseBody
    @GetMapping("/emailDupCheck")
    public int emailDupCheck(String inputEmail) {
    	System.out.println(inputEmail);
    	return userService.emailDupCheck(inputEmail);
    }
    
    /**
     * 로그인 페이지로 이동
     * @return
     */
    @GetMapping("/loginForm")
    public String loginForm(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception,
			Model model){
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	
    	if(authentication == null || AnonymousAuthenticationToken.class.isAssignableFrom(authentication.getClass())) {
    		// 로그인 한 사람이 없는 경우
    		
//    		error, exception을 모델에 담아 view로 
    		if(error != null) { // 로그인 실패의 경우
    			model.addAttribute("error",error);
    			model.addAttribute("exception",exception);
    			
    			return "loginPage";
    		} else {
    			// 로그인 성공의 경우
    			return "loginPage";
    		} 
    		
    	} else {
    		// 로그인 한 사람이 있는 경우
    		return "redirect:/";
    	}
    }
    
    
    /**
     * 회원 목록 페이지로 이동
     * @param model
     * @return
     * @throws Exception
     */
	@GetMapping("/list")
	public String selectAllUser(
			@RequestParam(value="cp", required=false, defaultValue = "1") int cp, 
			Model model) throws Exception {
		
		try {
			Map<String, Object> map = null;
			
			map = userService.selectAllUser(cp);
			
			model.addAttribute("map", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "userList";
		
	}
	
	
	/**
	 * 회원 정보 수정 form으로 이동
	 */
	@GetMapping("/detail/{userNo}")
    public String userDetailForm(@PathVariable("userNo") int userNo,
    		@RequestParam(value = "cp", required = false, defaultValue = "1") int cp,
    		Principal principal,
    		Model model) throws Exception {
		
		// 로그인 한 회원 1명의 정보 
		try {
			
			String userId = principal.getName();
			
			User loginUser = userService.selectLoginUser(userId);
			
			if(loginUser.getUserNo() == userNo) {
				// 로그인 한 유저와 클릭한 유저가 같을 경우
				model.addAttribute("loginuser", loginUser);
				return "userDetail";
			} 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/user/list";		
    }
	

	
    /**
     * 회원정보 수정 진행
     * @param user
     * @return
     */
    @PostMapping("/detail/update")
    public String userUpdate(User user) {
       
    	// PUT 요청 : 리소스를 생성 및 업데이트 하기 위해 서버로 데이터를 보낼 때 쓰는 방법
    	// post와 put의 차이 : put 요청은 멱등성 유지, 동일한 put 요청을 여러 번 호출해도 항상 동일한 결과 생성
    	// 멱등성 : 여러 번 수행해도 결과가 같은 성질, 호출로 인해 데이터가 변경되지 않는다.
    	
    	// @RequestParam("name속성값") 자료형 변수명 : 클라이언트 요청시 같이 전달된 파라미터를 변수에 저장
    	// name 속성 값을 이용해 지정!! name속성값과 파라미터를 저장할 변수 이름을 동일하게 작성하면 어노테이션 생략 가능
    	
    	// @RequestParam Map<String, Object> paramMap
    	// 요청 시 전달된 파라미터를 구분하지 않고 모두 map에 담아서 얻어옴
    	// name 속성 값이 map의 key
    	
    	
        
        return "redirect:/"; 
    }
    
    
}
