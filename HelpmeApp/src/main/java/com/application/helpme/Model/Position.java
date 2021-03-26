package com.application.helpme.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Position extends GeoElement {


	
	private Double Long;
	private Double Lat;
	
	
	

	public Position() {
		
	}
	public Position(Double l, Double lat) {
		super();
		Long = l;
		Lat = lat;
	}
	
	public Double getLong() {
		return Long;
	}
	public void setLong(Double l) {
		Long = l;
	}
	public Double getLat() {
		return Lat;
	}
	public void setLat(Double lat) {
		Lat = lat;
	}



	public double distance(Position pos1 , Position pos2 ) {
		
		
		double long1 = pos1.getLong();
		
		
		double lat1= pos1.getLat();
		
		double long2 =pos2.getLong();
		double lat2=pos2.getLat();
	
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    
	    System.out.println("Methode distance classe Position lancé");
	    return result;  // 2 * R; R = 6371 km		
	}
	
	
	public double distanceMissionPosArrive(Mission missionPos , Position pos ) {
		
		
		double long1 = missionPos.getPos().getLong();
		
		
		double lat1= missionPos.getPos().getLat();
		
		double long2 = pos.getLong();
		double lat2=pos.getLat();
	
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    
	    System.out.println("Methode distance classe Position lancé");
	    return result;  // 2 * R; R = 6371 km		
	}
	

	
	
	

	


	
	
	

	
	
}
