package com.springjpa.jpa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmployeeModel {
	
	@Schema(description = "First Name", example = "john")
	private String firstName;
	
	@Schema(description = "Last Name", example = "john")
	private String lastName;
	

}
