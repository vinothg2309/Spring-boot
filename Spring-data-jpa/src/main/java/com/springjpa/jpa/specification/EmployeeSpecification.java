package com.springjpa.jpa.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.springjpa.jpa.entity.Employee;

public class EmployeeSpecification {
	
	public static Specification<Employee> employeeSearchByFirstNameContains(String firstName){
		return new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%"+firstName.toLowerCase()+"%");
			}
		};
	}
	
	public static Specification<Employee> searchByLastNameContains(String lastName){
		return new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				return criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%"+lastName.toLowerCase()+"%");
			}
		};
	}

}
