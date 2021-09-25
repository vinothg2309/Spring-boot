package com.springjpa.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.jpa.model.User;
import com.springjpa.jpa.repository.UserRepository;
import com.springjpa.jpa.service.UserService;

@RestController
@RequestMapping("/user/")
public class ApplicationJPAController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/process")
	public String process() {
		return "Processing ...";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		//userRepository.findAll().stream().map(obj -> obj.setPassword(passwordEncoder.);)
		return userRepository.findAll();
	}
	
	// http://localhost:8001/user/getUsersByPagination/0/10/password/desc
	@GetMapping("/getUsersByPagination/{pageNo}/{noOfRecord}/{sortColumn}/{sortingOrder}")
	public List<User> getAllUsersPagination(@PathVariable Integer pageNo, @PathVariable Integer noOfRecord,
			@PathVariable String sortColumn, @PathVariable String sortingOrder) {
		return userService.findEmployeeByPagination(pageNo, noOfRecord, sortColumn, sortingOrder);
	}

}
