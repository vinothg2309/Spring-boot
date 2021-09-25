package com.springjpa.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springjpa.jpa.model.User;
import com.springjpa.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findEmployeeByPagination(Integer pageNo, Integer noOfRecord, String sortColumn, String sortingOrder) {
		Sort sort = Sort.by(sortColumn);
		if("asc".equalsIgnoreCase(sortingOrder))
		{
			sort.ascending();
		}
		else
		{
			sort.descending();
		}
		// Page number starts with 0
		Pageable pageReq = PageRequest.of(pageNo, noOfRecord, sort);
		return userRepository.findAll(pageReq).getContent();
	}

}
