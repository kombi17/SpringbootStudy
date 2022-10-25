package com.ishift.bootStudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
	// https://spring.io/guides/gs/securing-web/ 
	// 기존에는 WebSecurityConfigurerAdapter 클래스를 상속 받아 구현했지만 현재 deprecated
	// SecurityFilterChain 를 빈으로 등록하는 방식 권장
	
//	로그인 성공 핸들러
//	로그인 성공 시 home 페이지만 뜨도록 했기 때문에 따로 사용하지 않음
	@Autowired
	private AuthenticationSuccessHandler customAuthenticationSuccessHandler;

//	로그인 실패 핸들러
//	실패 시 alert(실패 안내 및 이유) 
//	로그인 페이지로 이동
//	로그인 실패 핸들러 의존성 주입
	@Autowired
	private AuthenticationFailureHandler customAuthenticationFailureHandler;
	
	// remember-me 기능 사용을 위해 사용자 정보를 연결해주는 필수 옵션 UserDetailsService 
	@Autowired
	private UserDetailsService userDetailService;
	
	// 비밀번호를 암호화하여 DB에 저장할 수 있도록 bean으로 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	// 인증을 무시하기 위한 설정
	// 기존에는 WebSecurityConfigurerAdapter를 상속했었기 때문에 override 어노테이션을 썼으나 지금은 X
	// WebSecurityCustomizer를 빈으로 등록
	// WebSecurity 요청을 무시하도록 구성하는 경우 대신 
	// permitAll HttpSecurity #authorizeHttpRequests를 사용하는 것이 권장됨 
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		// /resources/ 이하 css, js, img 기타 등등 정적 리소스의 인증 검사를 무시하도록
		return (web) -> web.ignoring().antMatchers("/resources/**"); 
	}
	
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        	.csrf().disable() // 일반 사용자에 대해 session을 저장하지 않으므로 csrf를 disable 처리
            .authorizeHttpRequests((authz) -> authz
				// .antMatchers : 페이지에 접근할 수 있는 권한 설정
				// 로그인, 회원가입, 홈 접근 허용
				.antMatchers("/", "/user/loginForm", "/user/signUp").permitAll() 
                .anyRequest().authenticated()
                .and()
            )
            .rememberMe().key("key")
            .rememberMeParameter("remember-me") // 
            .tokenValiditySeconds(3600) // 쿠키 만료 시간 (1시간) default : 14일
            .alwaysRemember(false) // remember-me 기능 항상 실행 X
            .userDetailsService(userDetailService)
            .and()
            .formLogin((form) -> form // 로그인 설정
//            	하위 두 줄은 핸들러에서 설정했기 때문에 주석 처리함
//            	.defaultSuccessUrl("/") // 로그인 성공 시 home 화면으로 이동
//            	.failureUrl("/user/loginForm") // 로그인 실패 시 login 화면
//            	.loginPage("/user/loginForm") // 로그인 페이지 주소 설정
        		// 로그인페이지 form태그 action 속성 url : 해당 url로 진입 시 시큐리티가 로그인 기능을 위임 받아서 처리
        		// /user/login 이라는 주소를 컨트롤러에 만들 필요 없이 /user/login으로 들어오면 @Service 어노테이션으로 구현되고 
        		// UserDetailService를 구현한 클래스 내에 loadUserByUsername 메서드가 자동으로 실행
            	.loginProcessingUrl("/user/login") 
            	.usernameParameter("userId") // 권한 처리할 때 userId라는 명으로 파라미터를 받겠다. default : username
            	.passwordParameter("userPw") // default : password
            	// 로그인 성공 핸들러
            	.successHandler(customAuthenticationSuccessHandler)
            	// 로그인 실패 핸들러 : UserDetailService 구현 필수
            	.failureHandler(customAuthenticationFailureHandler)
            	.permitAll()
            	.and()
        	)
        	.logout((logout) -> logout.permitAll() // 로그아웃 설정
    			// AntPathRequestMatcher를 통해 logout 처리하는 url이 들어왔는지 확인 
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.logoutSuccessUrl("/") // 로그아웃 시 이동할 페이지
        		.invalidateHttpSession(true) // 세션 초기화
        		.and()
    		)
            .httpBasic(withDefaults())
	        .exceptionHandling();
            
        return http.build();
    }
    


}
