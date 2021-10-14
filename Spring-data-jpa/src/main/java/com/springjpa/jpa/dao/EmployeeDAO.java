package com.springjpa.jpa.dao;

import java.util.List;

import com.springjpa.jpa.entity.Employee;
import com.springjpa.jpa.model.EmployeeModel;

public interface EmployeeDAO {

	List<Employee> findEmployeeByText(String searchText);

	List<Employee> findEmployeeByTextUsingJPA(String searchText);

	List<Employee> findEmployeeByFirstOrLastNameUsingJPASpecification(EmployeeModel emp);

	List<Employee> findEmployeeByFirstAndLastNameUsingJPASpecification(EmployeeModel emp);

	List<Employee> findEmployeeByNameViaQueryDSL(EmployeeModel emp);

	List<Employee> findAllByEmployeeByNamedQuery(String firstName);

}
