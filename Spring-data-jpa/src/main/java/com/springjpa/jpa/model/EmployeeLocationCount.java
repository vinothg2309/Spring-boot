package com.springjpa.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeLocationCount {
	
	private String location;
    private Long total;

}
