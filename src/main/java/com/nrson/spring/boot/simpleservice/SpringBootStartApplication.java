package com.nrson.spring.boot.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStartApplication.class, args);
	}

	
	//GetMapping과 RequestMapping 차이점 
	//GetMapping은 RequestMapping(method = RequestMethod.GET)의 단축키 역할을 하는 합성 주석 
	
	@GetMapping
	public String HelloWorld() {
		return "Hello world"; 
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
}
