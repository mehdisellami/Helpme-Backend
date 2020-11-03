package com.application.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @NotBlank
    @Size(min=3, max = 50)
    private String name;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;
  

	@NaturalId
    @Email
    private String email;
	
	
    @NotBlank
    private String password;
	
	
    @NotBlank
    private String tel;

	
	
	
	public User() {
		super();
	}

	public User(Long id, @NotBlank @Size(min = 3, max = 50) String name,
			@NotBlank @Size(min = 3, max = 50) String username, @NotBlank @Email String email,
			@NotBlank String password, @NotBlank String tel) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel=tel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
	
	
	
	
}
