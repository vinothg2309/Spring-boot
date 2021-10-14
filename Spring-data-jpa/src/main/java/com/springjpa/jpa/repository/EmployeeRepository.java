package com.springjpa.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springjpa.jpa.entity.Employee;

public interface EmployeeRepository  extends JpaRepository<Employee, Long>, JpaSpecificationExecutor<Employee>{
	
	List<Employee> findByFirstNameOrLastNameIgnoreCase(String searchText, String searchText2);
	
	List<Employee> findAll(Specification<Employee> spec);
	
	// Its referring to named query available in Employee entity class. 
	// By default, Spring Data JPA checks for a named JPQL or a named native query that follows 
	// the naming convention <entity class name>.<repository method name>
	List<Employee> findAllByEmpFirstNameAndLastNameDesc(String first_name);

}
