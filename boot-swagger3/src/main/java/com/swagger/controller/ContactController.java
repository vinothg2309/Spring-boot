package com.swagger.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.tomcat.jni.Address;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Contact;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api")
@Tag(name = "contact", description = "the Contact API")
public class ContactController {

	List<Contact> contacts = loadContacts();

	@Operation(summary = "Find Contacts by name", description = "Name search by %name% format", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", 
					content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))) })	
	@GetMapping(value = "/contacts", produces = { "application/json", "application/xml" })
	public ResponseEntity<List<Contact>> findAll(
			@Parameter(description="Page number, default is 1") @RequestParam(value="page", defaultValue="1") int pageNumber,
			@Parameter(description="Name of the contact for search.") @RequestParam(required=false) String name) {
		return ResponseEntity.ok(contacts);
	}

	@Operation(summary = "Find contact by ID", description = "Returns a single contact", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = @Content(schema = @Schema(implementation = Contact.class))),
			@ApiResponse(responseCode = "404", description = "Contact not found") })
	@GetMapping(value = "/contacts/{contactId}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Contact> findContactById(
			@Parameter(description="Id of the contact to be obtained. Cannot be empty.", required=true)
			@PathVariable long contactId) {
		Contact contact = contacts.stream().filter(c -> c.getId() == contactId).findFirst().orElse(null);
		if(contact == null)
		{
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		}
		return new ResponseEntity<Contact>(contact, HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Add a new contact", description = "", tags = { "contact" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "201", description = "Contact created",
					content = @Content(schema = @Schema(implementation = Contact.class))), 
			@ApiResponse(responseCode = "400", description = "Invalid input"), 
			@ApiResponse(responseCode = "409", description = "Contact already exists") })	
	@PostMapping(value = "/contacts", consumes = { "application/json", "application/xml" })
	public ResponseEntity<Contact> addContact(
			@Parameter(description="Contact to add. Cannot null or empty.", 
			required=true, schema=@Schema(implementation = Contact.class))
			@Valid @RequestBody Contact contact) 
					throws URISyntaxException {
		return null;
	}

	@Operation(summary = "Update an existing contact", description = "", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "Contact not found"),
			@ApiResponse(responseCode = "405", description = "Validation exception") })
	@PutMapping(value = "/contacts/{contactId}", consumes = { "application/json", "application/xml" })
	public ResponseEntity<Void> updateContact(
			@Parameter(description="Id of the contact to be update. Cannot be empty.", 
			required=true)
			@PathVariable long contactId,
			@Parameter(description="Contact to update. Cannot null or empty.", 
			required=true, schema=@Schema(implementation = Contact.class))
			@Valid @RequestBody Contact contact) {
		return null;
	}

	@Operation(summary = "Update an existing contact's address", description = "", tags = { "contact" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation"),
			@ApiResponse(responseCode = "404", description = "Contact not found") })
	@PatchMapping("/contacts/{contactId}")
	public ResponseEntity<Void> updateAddress(
			@Parameter(description="Id of the contact to be update. Cannot be empty.",
			required=true)
			@PathVariable long contactId,
			@Parameter(description="Contact's address to update.",
			required=true, schema=@Schema(implementation = Address.class))
			@RequestBody Address address) {
		return null;
	}

	@Operation(summary = "Deletes a contact", description = "", tags = { "contact" })
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "successful operation"),
			@ApiResponse(responseCode = "404", description = "Contact not found") })
	@DeleteMapping(path="/contacts/{contactId}")
	public ResponseEntity<Void> deleteContactById(
			@Parameter(description="Id of the contact to be delete. Cannot be empty.",
			required=true)
			@PathVariable long contactId) {
		return null;
	}

	private List<Contact> loadContacts(){
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact(1, "Vinoth", "9845254", "vinoth@gmail", 
				"add1", "add2", "add3", "600014", "note1"));
		contacts.add(new Contact(2, "Kiru", "9845254", "vinoth@gmail", 
				"add1", "add2", "add3", "600014", "note1"));
		contacts.add(new Contact(3, "Arun", "9845254", "vinoth@gmail", 
				"add1", "add2", "add3", "600014", "note1"));
		contacts.add(new Contact(4, "naren", "9845254", "vinoth@gmail", 
				"add1", "add2", "add3", "600014", "note1"));
		return contacts;
	}
}