package com.springjpa.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.jpa.entity.Employee;
import com.springjpa.jpa.entity.Project;
import com.springjpa.jpa.model.EmpLocationCountInterface;
import com.springjpa.jpa.model.EmployeeLocationCount;
import com.springjpa.jpa.repository.ProjectRepository;

@RestController
@RequestMapping("/project/")
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	
	// HR Management System, Timesheet Managerment, Online Reservation,Employee Portal, PayCheck System,401K System
	@GetMapping("/findByName/{searchText}")
	public Project findByName(@PathVariable String searchText){
		return projectRepository.findByNameViaNamedNativeQuery(searchText);
	}
	
	@GetMapping("/empCountByLocation")
	public List<EmployeeLocationCount> fetchEmpCountByLocation(){
		return projectRepository.countNoOfEmployeeByLocationAggregate();
	}
	
	@GetMapping("/empCountByLocationViaInterface")
	public List<EmpLocationCountInterface> empCountByLocationViaInterface(){
		return projectRepository.countNoOfEmployeeByLocationAggregateInterface();
	}
	
	@GetMapping("/empCountByLocationViaNativeQuery")
	public List<EmpLocationCountInterface> empCountByLocationViaNativeQuery(){
		return projectRepository.noOfEmployeeByLocationAggregateInterfaceNative();
	}

}
