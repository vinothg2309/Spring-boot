package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoAuthenticationController {

	
	@GetMapping("/sayHi")
	public String sayHi() {
		return "hi";
	}
	
}
