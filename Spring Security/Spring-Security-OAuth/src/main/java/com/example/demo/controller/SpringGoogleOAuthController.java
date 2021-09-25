package com.example.demo.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringGoogleOAuthController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Google!!";
	}
	
	
	@GetMapping("/user")
	public Principal user(Principal principal) {
		System.out.println("username : "+principal.getName());
		return principal;
	}

	
}
