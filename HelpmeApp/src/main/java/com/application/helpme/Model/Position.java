package com.application.helpme.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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



	public double distance(Position p1 ) {
		
		
		double long1 = p1.getUserLocalise().getUserPos().getPos().getLong();
		System.out.println(long1);
		
		double lat1= p1.getUserLocalise().getUserPos().getPos().getLat();
		
		double long2 =p1.getMissionLocalise().getPos().getLong() ; 
		double lat2=p1.getMissionLocalise().getPos().getLat();
	
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    
	    System.out.println("Methode distance classe Position lancé");
	    return result;  // 2 * R; R = 6371 km		
	}
	
	

	
	
	

	


	
	
	

	
	
}
