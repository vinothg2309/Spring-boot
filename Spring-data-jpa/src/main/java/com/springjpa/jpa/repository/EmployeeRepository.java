package com.springjpa.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springjpa.jpa.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{
	
	List<Employee> findByFirstNameOrLastNameIgnoreCase(String searchText, String searchText2);
	
	List<Employee> findAll(Specification<Employee> spec);

}
