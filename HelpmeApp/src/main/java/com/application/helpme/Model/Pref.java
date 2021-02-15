package com.application.helpme.Model;

import java.util.prefs.PreferenceChangeEvent;

public class Pref {
	
	private boolean vieux;
	
	private boolean jeune;

	public Pref() {
		this.vieux=true;
		this.jeune=false;
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
	
	
	public boolean accepte(Pref o) {
		
		
	
		return true; 
	}
	
	
	

}
