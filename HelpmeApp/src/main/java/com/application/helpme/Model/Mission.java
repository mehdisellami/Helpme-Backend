package com.application.helpme.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table
public class Mission {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMission;
	
	
	@NotBlank
    private String nomMission;

	@NotBlank
    private String adressMission;
	
	LocalDate dateMission;
	
	private String tel;
	
	
	@NotBlank
    private String description;
	
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id")

	User userMission;
	
	


	


	


	public Mission() {
		
	}


	public Mission(Long idMission, @NotBlank String nomMission, @NotBlank String adressMission, LocalDate dateMission,
			@NotBlank String description, User userMission) {
		super();
		this.idMission = idMission;
		this.nomMission = nomMission;
		this.adressMission = adressMission;
		this.dateMission = dateMission;
		this.description = description;
		this.userMission = userMission;
	}


	public Long getIdMission() {
		return idMission;
	}


	public void setIdMission(Long idMission) {
		this.idMission = idMission;
	}


	public String getNomMission() {
		return nomMission;
	}


	public void setNomMission(String nomMission) {
		this.nomMission = nomMission;
	}


	public String getAdressMission() {
		return adressMission;
	}


	public void setAdressMission(String adressMission) {
		this.adressMission = adressMission;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	

	public LocalDate getDateMission() {
		return dateMission;
	}


	public void setDateMission(LocalDate dateMission) {
		this.dateMission = dateMission;
	}


	public User getUserMission() {
		return userMission;
	}


	public void setUserMission(User userMission) {
		this.userMission = userMission;
	}
	
	


	
	
	
	
	
	
	

	
	

}