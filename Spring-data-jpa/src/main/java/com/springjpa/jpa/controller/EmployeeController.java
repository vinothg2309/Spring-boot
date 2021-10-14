package com.springjpa.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.jpa.dao.EmployeeDAO;
import com.springjpa.jpa.entity.Employee;
import com.springjpa.jpa.model.EmployeeModel;

@RestController
@RequestMapping("/employee/")
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@GetMapping("/findEmployeeByText/{searchText}")
	public List<Employee> findEmployeeByText(@PathVariable String searchText){
		return employeeDAO.findEmployeeByText(searchText);
	}
	
	@GetMapping("/findEmployeeByTextUsingJPA/{searchText}")
	public List<Employee> findEmployeeByTextUsingJPA(@PathVariable String searchText){
		return employeeDAO.findEmployeeByTextUsingJPA(searchText);
	}
	
	//{ "firstName": "john", "lastName": "john"}
	@PostMapping("/findEmployeeByFirstOrLastNameSpec/")
	public List<Employee> findEmployeeByFirstOrLastNameUsingJPASpecification(@RequestBody EmployeeModel emp){
		return employeeDAO.findEmployeeByFirstOrLastNameUsingJPASpecification(emp);
	}
	
	//{ "firstName": "john", "lastName": "doe"}
	@PostMapping("/findEmployeeByFirstAndLastNameSpec/")
	public List<Employee> findEmployeeByFirstAndLastNameUsingJPASpecification(@RequestBody EmployeeModel emp){
		return employeeDAO.findEmployeeByFirstAndLastNameUsingJPASpecification(emp);
	}
	
	//{ "firstName": "john", "lastName": "doe"}
	@PostMapping("/findEmployeeByNameViaQueryDSL")
	public List<Employee> findEmployeeByNameViaQueryDSL(@RequestBody EmployeeModel emp){
		return employeeDAO.findEmployeeByNameViaQueryDSL(emp);
	}
	
	//{ "firstName": "john", "lastName": "doe"}
	@PostMapping("/findAllByEmployeeByNamedQuery/{firstName}")
	public List<Employee> findAllByEmployeeByNamedQuery(@PathVariable String firstName){
		return employeeDAO.findAllByEmployeeByNamedQuery(firstName);
	}

}
