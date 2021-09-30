package com.springjpa.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.jpa.entity.Role;

public interface UserRoleRepository extends JpaRepository<Role, Integer>{

}
