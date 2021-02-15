package com.application.helpme.Model;

import java.util.Map;

public class GeoElement extends Position {
	
	
	Position pos;
	
	UserLocalise userLocalise;
	Mission missionLocalise;
	
	

	public GeoElement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeoElement(Double l, Double lat) {
		super(l, lat);
		// TODO Auto-generated constructor stub
	}
	
	public Position pos() {
		
		return pos;
	}
	
	
	
	
	public UserLocalise getUserLocalise() {
		return userLocalise;
	}

	public void setUserLocalise(UserLocalise userLocalise) {
		this.userLocalise = userLocalise;
	}

	public Mission getMissionLocalise() {
		return missionLocalise;
	}

	public void setMissionLocalise(Mission missionLocalise) {
		this.missionLocalise = missionLocalise;
	}

	
	public double distance(GeoElement o) {
	return	this.pos.distance(o.getUserLocalise(), o.getMissionLocalise());
	}

	

}
