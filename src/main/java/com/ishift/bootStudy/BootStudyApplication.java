package com.ishift.bootStudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.ishift.bootStudy.config.SecurityConfiguration;

// @SpringBootApplication : 해당 어노테이션을 통해 스프링부트의 모든 설정이 관리됨
@SpringBootApplication
@MapperScan(basePackages = "com.ishift.bootStudy")
public class BootStudyApplication {
	
	// 시작을 담당하는 파일 
	// <프로젝트명> + Application.java
	
	// src/main/resources : 자바 파일을 제외한 html, css, js, 환경 파일 등을 작성하는 공간
	// templates : 템플릿 파일 저장, html파일 형태로 자바 객체와 연동되는 파일
	// static : css, js, 이미지 파일 등을 저장하는 공간
	// application.properties 파일 : 프로젝트의 환경 설정
	// src/test/java : 프로젝트에서 작성한 파일을 테스트 하기 위한 테스트 코드 작성 공간
	// 				   JUnit과 스프링부트의 테스팅 도구를 사용하여 서버를 실행하지 않고 테스트할 수 있다. 
	// build.gradle : 그레이들(gradle)이 사용하는 환경 파일, 프로젝트에 필요한 플러그인과 라이브러리 기술
	// gradle : 그루비(Groovy)를 기반으로 한 빌드 도구로 이전 세대 빌드 도구의 단점을 보완하고 장점을 취합하여 만든 빌드 도구

	public static void main(String[] args) {
		SpringApplication.run(BootStudyApplication.class, args);
	}

}
