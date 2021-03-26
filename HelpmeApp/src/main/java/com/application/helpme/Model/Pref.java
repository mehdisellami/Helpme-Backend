package com.application.helpme.Model;

import java.util.prefs.PreferenceChangeEvent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Table
public class Pref {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private boolean vieux;
	
	private boolean jeune;

	public Pref() {
		
		// TODO Auto-generated constructor stub
	}
	

	public Pref(boolean vieux, boolean jeune) {
		super();
		this.vieux = vieux;
		this.jeune = jeune;
	}


	public Pref(boolean jeune) {
		
		this.jeune = true;
		this.vieux=false;
	}
	



	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isVieux() {
		return vieux;
	}

	public void setVieux(boolean vieux) {
		this.vieux = vieux;
	}

	public boolean isJeune() {
		return jeune;
	}

	public void setJeune(boolean jeune) {
		this.jeune = jeune;
	}
	
	
	public boolean accepte(User userpref ,Mission mpref ) {
		boolean rtr=false;
		
		
		if (userpref.getPrefUser().isJeune() &&  mpref.getPrefMission().isJeune() ) {
			System.out.println("L'utilisi est compatible avec la mission "+mpref.getNomMission()+" && Jeune");

			rtr=true;
		
		}
		
		
		else if (userpref.getPrefUser().isVieux() &&  mpref.getPrefMission().isVieux() ) {	
			rtr = true;
			System.out.println("L'utilisi est compatible avec la mission && VIEUX");
		}
		
		else {System.out.println("L'utilisi n'est pas compatible avec la mission");
			rtr=false;
		}
	
	
		return rtr; 
	}
	
	
	

}
