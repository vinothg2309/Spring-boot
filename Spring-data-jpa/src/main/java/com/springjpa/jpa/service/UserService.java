package com.springjpa.jpa.service;

import java.util.List;

import com.springjpa.jpa.model.User;

public interface UserService {
	
	public List<User> findEmployeeByPagination(Integer pageNo, Integer noOfRecord, String sortColumn, String sortingOrder);

}
