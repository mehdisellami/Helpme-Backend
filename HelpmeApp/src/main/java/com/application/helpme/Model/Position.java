package com.application.helpme.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Position {

	
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



	public double distance(UserLocalise ul , Mission m) {
		double long1 = ul.getLong();
		
		double lat1= ul.getLat();
		
		double long2 =m.getLong() ; 
		double lat2=m.getLat();
	
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    return result;  // 2 * R; R = 6371 km		
	}
	
	

	
	
	

	


	
	
	

	
	
}
