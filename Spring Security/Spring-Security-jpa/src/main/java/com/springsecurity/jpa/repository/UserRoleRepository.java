package com.springsecurity.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springsecurity.jpa.model.Role;

public interface UserRoleRepository extends JpaRepository<Role, Integer>{

}
