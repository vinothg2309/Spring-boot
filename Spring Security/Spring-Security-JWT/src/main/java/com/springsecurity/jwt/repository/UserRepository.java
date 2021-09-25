package com.springsecurity.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.jwt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User findByUserName(String username);

}
