package com.springsecurity.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.jpa.model.User;
import com.springsecurity.jpa.repository.UserRepository;

@RestController
@RequestMapping("/rest/auth")
public class ApplicationJPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/process")
	public String process() {
		return "Processing ...";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		//userRepository.findAll().stream().map(obj -> obj.setPassword(passwordEncoder.);)
		return userRepository.findAll();
	}

}
