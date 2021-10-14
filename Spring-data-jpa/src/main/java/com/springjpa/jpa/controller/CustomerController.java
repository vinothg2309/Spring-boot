package com.springjpa.jpa.controller;


import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.springjpa.jpa.model.Customer;
import com.springjpa.jpa.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ObjectMapper objectMapper;

	// { "id":"1", "telephone":"001-555-1234", "favorites":["Milk","Eggs"]}
	@PostMapping(path = "/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	// { "id":"1","telephone":"002-666-5678", "favorites":["Milk","Eggs","Meat"]}
	@PutMapping(path = "/updateViaPut")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customerToUpdate) {
		Customer customer = customerRepository.findById(customerToUpdate.getId()).orElse(null);
		if(customer != null)
		{
			customerRepository.save(customerToUpdate);
			return ResponseEntity.ok(customerToUpdate);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	// ******** https://www.baeldung.com/spring-rest-json-patch **********
	@PatchMapping(path = "/updateViaPatch/{id}", consumes = "application/json-patch+json")
	// [{ "op":"replace", "path":"/telephone", "value":"001-555-5678"}]
	/*[
    {"op":"replace","path":"/telephone","value":"+1-555-56"},
    {"op":"add","path":"/favorites/0","value":"Bread"}
    ]*/
	public ResponseEntity<Customer> updateViaPatch(@PathVariable Integer id, @RequestBody JsonPatch patch) throws JsonProcessingException, JsonPatchException {
		Customer customer = customerRepository.findById(id).orElse(null);
		if(customer != null) {
			Customer customerPatched = applyPatchToCustomer(patch, customer);
			customerRepository.save(customerPatched);
			return ResponseEntity.ok(customerPatched);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	private Customer applyPatchToCustomer(
			JsonPatch patch, Customer targetCustomer) throws JsonPatchException, JsonProcessingException {
		JsonNode patched = patch.apply(objectMapper.convertValue(targetCustomer, JsonNode.class));
		System.out.println("patched : "+ patched);
		return objectMapper.treeToValue(patched, Customer.class);
	}

	private void patch(Integer id, Map<String, String> customer2) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if(optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			//objectMapper.readerForUpdating(customer).readValue(customer2);
		}
	}

}
