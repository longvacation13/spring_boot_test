package com.nrson.spring.boot.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController 어노테이션 - Restful Web API 생성을 손쉽게 제공하기 위한 기능 MVC 환경의 Controller와
 * Responsebody를 합쳐놓은 어노테이션 MVC 환경에서 Controller는 View에 초점을 맞춘 방식 -
 * RestController는 data에 초점을 두고 접근함
 * 
 * @author junyoung
 */
@RestController
@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}

	/**
	 * 
	 * GetMapping과 RequestMapping 차이점 description : GetMapping은
	 * RequestMapping(method = RequestMethod.GET)의 단축키 역할을 하는 합성 주석
	 * 
	 * @return String
	 */
	@GetMapping("/helloworld")
	public String HelloWorld() {
		return "Hello world!!!1234";
	}

	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

}
