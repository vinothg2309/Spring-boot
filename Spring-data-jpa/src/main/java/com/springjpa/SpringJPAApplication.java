package com.springjpa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.jpa.model.User;
import com.springjpa.jpa.repository.UserRepository;

@SpringBootApplication
public class SpringJPAApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJPAApplication.class, args);
	}

	@PostConstruct
	public void initUsers() {
		repository.deleteAll();
		List<User> users = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			int temp = i+1;
			users.add(new User(temp, "user"+temp, "pwd"+temp, "user"+temp+"@gmail.com"));
		}
		repository.saveAll(users);
	}

}
