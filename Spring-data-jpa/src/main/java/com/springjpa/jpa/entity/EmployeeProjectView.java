package com.springjpa.jpa.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Immutable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pavan Jadda
 */
@Data
@Entity
@Immutable
@Table(name = "employee_project_view")
@NoArgsConstructor
public class EmployeeProjectView implements Serializable
{
	private static final long serialVersionUID = 1916548443504880237L;

	@Id
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "project_id")
	private Long projectId;

	@Column(name = "project_name")
	private String projectName;

	@Column(name = "project_budget")
	private Double projectBudget;

	@Column(name = "project_location")
	private String projectLocation;

}
