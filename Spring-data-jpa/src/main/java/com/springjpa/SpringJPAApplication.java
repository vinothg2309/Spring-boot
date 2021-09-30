package com.springjpa;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springjpa.jpa.entity.Employee;
import com.springjpa.jpa.entity.Project;
import com.springjpa.jpa.entity.User;
import com.springjpa.jpa.repository.EmployeeRepository;
import com.springjpa.jpa.repository.ProjectRepository;
import com.springjpa.jpa.repository.UserPageableRepository;

@SpringBootApplication
public class SpringJPAApplication {

	@Autowired
	private UserPageableRepository repository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringJPAApplication.class, args);
	}

	@PostConstruct
	public void initUsers() {
		List<User> users = new ArrayList<>();
		
		for (int i = 0; i < 20; i++) {
			int temp = i+1;
			users.add(new User(temp, "user"+temp, "pwd"+temp, "user"+temp+"@gmail.com"));
		}
		repository.saveAll(users);
		loadEmployee();
	}

	private void loadEmployee() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(new Long(1),  "John",  "Doe", null, null, null));
		employees.add(new Employee(new Long(2),  "Jack",  "Reacher", null, null, null));
		employees.add(new Employee(new Long(3),  "John",  "Reese", null, null, null));
		employees.add(new Employee(new Long(4),  "Steve",  "John", null, null, null));
		employees.add(new Employee(new Long(5),  "Tony",  "Jack", null, null, null));
		employees.add(new Employee(new Long(6),  "Mark",  "Modaha", null, null, null));
		employeeRepository.saveAll(employees);
		
		 
		 List<Project> projects = new ArrayList<>();
		 projects.add(new Project(new Long(1),  "HR Management System", new Double(1000),  "DC",  "Internal"));
		 projects.add(new Project(new Long(2),  "Timesheet Managerment", new Double(1000),  "NYC",  "Contract"));
		 projects.add(new Project(new Long(3),  "Online Reservation", new Double(1000),  "LA",  "Contract"));
		 projects.add(new Project(new Long(4),  "Employee Portal", new Double(1000),  "Chicago",  "Internal"));
		 projects.add(new Project(new Long(5),  "PayCheck System", new Double(1000),  "Chicago",  "Internal"));
		 projects.add(new Project(new Long(6),  "401K System", new Double(1000),  "Chicago",  "Internal"));
		 projectRepository.saveAll(projects);
	}

	@PreDestroy
	public void destroy() {
		repository.deleteAll();
		employeeRepository.deleteAll();
		projectRepository.deleteAll();
	}

}
