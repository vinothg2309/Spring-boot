package com.springjpa.jpa.dao.impl;

import static org.springframework.data.jpa.domain.Specification.where;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springjpa.jpa.dao.EmployeeDAO;
import com.springjpa.jpa.entity.Employee;
import com.springjpa.jpa.entity.QEmployee;
import com.springjpa.jpa.model.EmployeeModel;
import com.springjpa.jpa.repository.EmployeeQueryDSLRepository;
import com.springjpa.jpa.repository.EmployeeRepository;
import com.springjpa.jpa.specification.EmployeeSpecification;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeQueryDSLRepository employeeQueryDSLRepository;

	@Override
	public List<Employee> findEmployeeByText(String searchText) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);

		criteriaQuery.select(employeeRoot);
		Predicate firstNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(employeeRoot.get("firstName"))
				, "%"+searchText.toLowerCase()+"%");
		Predicate lastNamePredicate = criteriaBuilder.like(criteriaBuilder.lower(employeeRoot.get("lastName"))
				, "%"+searchText.toLowerCase()+"%");
		Predicate firstOrLastNamePredicate = criteriaBuilder.or(firstNamePredicate, lastNamePredicate);
		criteriaQuery.where(firstOrLastNamePredicate);

		TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
		List<Employee> employeeList = typedQuery.getResultList();
		return employeeList;
	}

	@Override
	public List<Employee> findEmployeeByTextUsingJPA(String searchText) {
		return employeeRepository.findByFirstNameOrLastNameIgnoreCase(searchText, searchText);
	}

	@Override
	public List<Employee> findEmployeeByFirstOrLastNameUsingJPASpecification(EmployeeModel emp) {
		List<Employee> employees = new ArrayList<>();
		if(StringUtils.isNotBlank(emp.getFirstName())) {
			employees = employeeRepository.findAll(EmployeeSpecification.employeeSearchByFirstNameContains(emp.getFirstName()));
		}
		else if(StringUtils.isNotBlank(emp.getLastName())){
			employees = employeeRepository.findAll(EmployeeSpecification.searchByLastNameContains(emp.getLastName()));
		}
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByFirstAndLastNameUsingJPASpecification(EmployeeModel emp) {
		return employeeRepository.findAll(where(EmployeeSpecification.employeeSearchByFirstNameContains(emp.getFirstName())
				.and(EmployeeSpecification.searchByLastNameContains(emp.getLastName()))));
	}

	@Override
	public List<Employee> findEmployeeByNameViaQueryDSL(EmployeeModel emp) {
		JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
		QEmployee employee = QEmployee.employee;
		List<Employee> employees = queryFactory.selectFrom(employee)
				  .where(employee.firstName.contains(emp.getFirstName())
						  .or(employee.lastName.contains(emp.getLastName())))
				  .fetch();
		
		return employees;
	}

	@Override
	public List<Employee> findAllByEmployeeByNamedQuery(String firstName) {
		return employeeRepository.findAllByEmpFirstNameAndLastNameDesc(firstName);
	}
	
	



}
