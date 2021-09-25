package com.springsecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PwdDecode {
	
	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "kiruba1";
		String encodedPassword = "$2a$10$TiUUThhq5yKfRdvCb9m2p.vG0cw7pju2HK7be.Lr.DF6pBHAI4cZW";
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);

		password = "password@1";
		isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);
	}

}
