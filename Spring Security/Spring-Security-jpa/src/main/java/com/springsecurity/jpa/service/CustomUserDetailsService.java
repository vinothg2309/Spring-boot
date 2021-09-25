package com.springsecurity.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springsecurity.jpa.model.User;
import com.springsecurity.jpa.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		CustomUserDetails customUserDetails = null;
		if(user != null) {
			customUserDetails = new CustomUserDetails();
			customUserDetails.setUser(user);
		}else {
			throw new UsernameNotFoundException("User not exist with name : "+ username);
		}
		return customUserDetails;
	}

}
