package com.springsecurity.jwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.springsecurity.jwt.entity.User;
import com.springsecurity.jwt.repository.UserRepository;

@SpringBootApplication
@EnableWebSecurity
public class SpringSecurityApplication {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}
	
	@PostConstruct
	public void initUsers() {
		userRepository.deleteAll();
        List<User> users = Stream.of(
                new User(101, "vinoth1", "vinoth1", "vinoth1@gmail.com"),
                new User(102, "user1", "pwd1", "user1@gmail.com"),
                new User(103, "user2", "pwd2", "user2@gmail.com"),
                new User(104, "user3", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        userRepository.saveAll(users);
    }

}
