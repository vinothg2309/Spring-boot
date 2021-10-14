package com.springjpa.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.springjpa.jpa.entity.Employee;

public interface EmployeeQueryDSLRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee>{

}
