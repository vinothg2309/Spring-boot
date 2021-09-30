package com.springjpa.jpa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter	
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	@Schema(description = "User Name", required = true)
	@NotBlank
	private String userName;
	
	@Schema(description = "Password", required = true)
	@NotBlank
	private String password;
	
	@Schema(description = "Email", required = true)
	@NotBlank
	private String email;
	
	@JsonInclude
	@Transient
	private int pageNo;
	
	@JsonInclude
	@Transient
	private int noOfRecord;
	
	@JsonInclude
	@Transient
	private String sortingColumn;
	
	@JsonInclude
	@Transient
	private String sortingOrder;
	
	// user & role mapping is maintained in separate table
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name="user_id")
		, inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;

	public User(int userId, String userName, String password, String email) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

}
