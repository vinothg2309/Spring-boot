package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest/auth")
public class RestController {
	
	@GetMapping("/getMsg")
	public String greetings() {
		return "Spring Security Example";
	}
	

}
