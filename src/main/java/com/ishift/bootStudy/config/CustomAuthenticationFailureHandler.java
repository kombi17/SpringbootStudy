package com.ishift.bootStudy.config;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	
	/* SimpleUrlAuthenticationFailureHandler : AuthenticationFailureHandler 를 구현한 구현체
	 * 해당 클래스가 제공하는 setDefaultFailureUrl() 메서드를 활용하기 위해 
	 * 	-> 로그인 실패 시 url을 지정해주고 해당 url은 컨트롤러에 매핑
	 */
	
//	HttpServletRequest : request 정보
//	HttpServletResponse : response에 대해 설정할 수 있는 변수
//	AuthenticationException : 로그인 실패 시 예외에 대한 정보

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String errorMsg;
		System.out.println("e " + exception);
		if(exception instanceof BadCredentialsException) {
			errorMsg = "ID or Password is mismatched! plz check again.";
		} else if(exception instanceof InternalAuthenticationServiceException) {
			errorMsg = "내부적으로 발생한 시스템 문제";
		} else if(exception instanceof UsernameNotFoundException) {
			errorMsg = "계정이 존재하지 않습니다. 회원가입 후 로그인 해주세요.";	
		} else {
			errorMsg = "알 수 없는 이유로 로그인 실패!";
		}
		
		// 한글 인코딩 깨짐 방지
		errorMsg = URLEncoder.encode(errorMsg, "UTF-8");
		
		// 로그인 실패 시 url 지정, url은 컨트롤러에 매핑되어있어야 함! 
		setDefaultFailureUrl("/user/loginForm?error=true&exception=" + errorMsg);

		// 이 부분은 왜 쓰는지 잘 이해 못 했음!! 
		// 실패와 관련된 여러가지 후속 처리를 해주기 때문에 super클래스를 호출하여 썼다는데... 
		super.onAuthenticationFailure(request, response, exception);
		
	}

}
