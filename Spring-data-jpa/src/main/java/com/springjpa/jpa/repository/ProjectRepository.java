package com.springjpa.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springjpa.jpa.entity.Project;
import com.springjpa.jpa.model.EmpLocationCountInterface;
import com.springjpa.jpa.model.EmployeeLocationCount;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	// Customizing the Result with Class Constructors
	@Query("SELECT new com.springjpa.jpa.model.EmployeeLocationCount(p.location, COUNT(p.location))"
			+ " FROM Project p GROUP BY p.location")
	List<EmployeeLocationCount> countNoOfEmployeeByLocationAggregate();
	
	/*
	 * To use interface-based projection, we must define a Java interface composed
	 * of getter methods that match the projected attribute names. To allow Spring
	 * to bind the projected values to our interface, we need to give aliases to
	 * each projected attribute with the property name found in the interface.
	 */
	@Query("SELECT p.location AS location, COUNT(p.location) As employeeCount"
			+ " FROM Project p GROUP BY p.location")
	List<EmpLocationCountInterface> countNoOfEmployeeByLocationAggregateInterface();
	
	
	// Customizing the Result of Native Queries. 
	// One advantage of interface-based projection is that we can use it for native queries
	@Query(value="SELECT p.location AS location, COUNT(p.location) As employeeCount"
			+ " FROM project_table p GROUP BY p.location", nativeQuery = true)
	List<EmpLocationCountInterface> noOfEmployeeByLocationAggregateInterfaceNative();

	Project findByNameViaNamedNativeQuery(String name);
	

}
