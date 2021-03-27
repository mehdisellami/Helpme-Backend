package com.application.helpme.Model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table
public class Mission extends GeoElement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private Long idMission;
	
	private int idMission;
	@NotBlank
    private String nomMission;

	@NotBlank
    private String adressMission;
	
	LocalDate dateMission;
	
	private String tel;
	
	@NotBlank
	private String trancheAge;
	
	
	@NotBlank
    private String description;
	
	@Enumerated(EnumType.ORDINAL)
	private etatMission statusMission = etatMission.ENATTENTE;
	
	@Enumerated(EnumType.ORDINAL)
	private FeedbackMission feedbackNote = FeedbackMission.ETOILE0;
	
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "id")

	User userMission ;
	
	private String commentaire;

	@Transient
	Position pos;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @ Entity
    Pref prefMission;
	
	
	
	public Mission() {
		
	}
	
	
	

public Mission(int idMission, @NotBlank String nomMission, @NotBlank String adressMission, Position pos) {
		super();
		this.idMission = idMission;
		this.nomMission = nomMission;
		this.adressMission = adressMission;
		this.pos = pos;
	}




public Mission(@NotBlank String nomMission, @NotBlank String adressMission, LocalDate dateMission, String tel,
		@NotBlank String description, etatMission statusMission, FeedbackMission feedbackNote, User userMission,
		String commentaire, Position pos, @NotBlank String trancheAge) {
	super();
	this.nomMission = nomMission;
	this.adressMission = adressMission;
	this.dateMission = dateMission;
	this.tel = tel;
	this.description = description;
	this.statusMission = statusMission;
	this.feedbackNote = feedbackNote;
	this.userMission = userMission;
	this.commentaire = commentaire;
	this.pos = pos;
	this.trancheAge = trancheAge;
}









//	public Mission(Long idMission, @NotBlank String nomMission, @NotBlank String adressMission, LocalDate dateMission,
//			@NotBlank String description, User userMission) {
//		super();
//		this.idMission = idMission;
//		this.nomMission = nomMission;
//		this.adressMission = adressMission;
//		this.dateMission = dateMission;
//		this.description = description;
//		this.userMission = userMission;	
//	}
//
//	
//	
//	public Mission(Long idMission, @NotBlank String nomMission, @NotBlank String adressMission, LocalDate dateMission,
//			String tel, @NotBlank String description, etatMission statusMission, FeedbackMission feedbackNote,
//			User userMission, String commentaire, Position pos) {
//		super();
//		this.idMission = idMission;
//		this.nomMission = nomMission;
//		this.adressMission = adressMission;
//		this.dateMission = dateMission;
//		this.tel = tel;
//		this.description = description;
//		this.statusMission = statusMission;
//		this.feedbackNote = feedbackNote;
//		this.userMission = userMission;
//		this.commentaire = commentaire;
//		this.pos = pos;
//	}
//
//	
//
//
//
//	public Mission(Long idMission, @NotBlank String nomMission, @NotBlank String adressMission, Position pos) {
//		super();
//		this.idMission = idMission;
//		this.nomMission = nomMission;
//		this.adressMission = adressMission;
//		this.pos = pos;
//	}
//
//
//
//
//	public Long getIdMission() {
//		return idMission;
//	}
//
//	public void setIdMission(Long idMission) {
//		this.idMission = idMission;
//	}


	public int getIdMission() {
		return idMission;
	}


	


	public void setIdMission(int idMission) {
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


	public etatMission getStatusMission() {
		return statusMission;
	}


	public void setStatusMission(etatMission statusMission) {
		this.statusMission = statusMission;
	}


	public FeedbackMission getFeedbackNote() {
		return feedbackNote;
	}


	public void setFeedbackNote(FeedbackMission feedbackNote) {
		this.feedbackNote = feedbackNote;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String telephone) {
		this.tel = telephone;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}




	public Pref getPrefMission() {
		return prefMission;
	}




	public void setPrefMission(Pref prefMission) {
		this.prefMission = prefMission;
	}


	
	public String getTrancheAge()
	{
		return trancheAge;
	}
	
	public void setTrancheAge(String tran)
	{
		this.trancheAge = tran;
	}




	






	
	
	
	

}
