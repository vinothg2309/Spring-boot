package com.springjpa.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.jpa.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
