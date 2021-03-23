package com.application.helpme.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long id;
	
	private int id;
	
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
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @Transient
    Position pos;
    
    @Transient
    Pref prefUser;
    
    int age ; 
     
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "userMissionCreateur")
	Mission userMissionCreateur;
 
	public User() {
		super();
	}
		
	public User(int id, @NotBlank @Size(min = 3, max = 50) String name, Position pos) {
		super();
		this.id = id;
		this.name = name;
		this.pos = pos;
	}

	public User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
			@Email String email, @NotBlank String password, @NotBlank String tel) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel = tel;
	}
	
	public int getId() {
		return id;
	}

	public User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
		@Email String email, @NotBlank String password, @NotBlank String tel, Set<Role> roles, Position pos,
		Pref prefUser) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.roles = roles;
		this.pos = pos;
		this.prefUser = prefUser;
	}

	public User(@NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
			@Email String email, @NotBlank String password, @NotBlank String tel, Set<Role> roles, Position pos,
			Pref prefUser, Mission userMissionCreateur) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel = tel;
		this.roles = roles;
		this.pos = pos;
		this.prefUser = prefUser;
		this.userMissionCreateur = userMissionCreateur;
	}

	public User(int id, @NotBlank @Size(min = 3, max = 50) String name, Position pos, Pref prefUser,
			Mission userMissionCreateur) {
		super();
		this.id = id;
		this.name = name;
		this.pos = pos;
		this.prefUser = prefUser;
		this.userMissionCreateur = userMissionCreateur;
	}

	public User(int id, @NotBlank @Size(min = 3, max = 50) String name, Position pos, Pref prefUser) {
		super();
		this.id = id;
		this.name = name;
		this.pos = pos;
		this.prefUser = prefUser;
	}

	public User(int id, @NotBlank @Size(min = 3, max = 50) String name, @NotBlank @Size(min = 3, max = 50) String username,
			@Email String email, @NotBlank String password, @NotBlank String tel) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.tel = tel;
	}

	public void setId(int id) {
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public Pref getPrefUser() {
		return prefUser;
	}

	public void setPrefUser(Pref prefUser) {
		this.prefUser = prefUser;
	}

	public Mission getUserMissionCreateur() {
		return userMissionCreateur;
	}

	public void setUserMissionCreateur(Mission userMissionCreateur) {
		this.userMissionCreateur = userMissionCreateur;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}