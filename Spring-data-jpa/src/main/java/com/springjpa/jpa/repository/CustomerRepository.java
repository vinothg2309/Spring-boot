package com.springjpa.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.jpa.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
