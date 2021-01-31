package com.application.helpme.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agence {
	
	List <Mission> listeMission= new ArrayList<>();
	

	public Agence(List<Mission> listeMission) {
		super();
		this.listeMission = listeMission;
	}

	public List<Mission> getListeMission() {
		return listeMission;
	}

	public void setListeMission(List<Mission> listeMission) {
		this.listeMission = listeMission;
	}
	
	
	
	
	public Agence() {
		super();
	}

	public Map<Mission,Double> selectionner(User u ,Position p){
		
		Map <Mission,Double> res = new HashMap<Mission, Double>();
		
		for (Mission m : listeMission) {
			
			double d1 = distance(u.getPos(),m.getPos());
			double d2 = distance(m.getPos(),p);
			double result=d1+d2;
			
				
		
				res.put(m, result);
				
			
		}
		

		res.forEach((k,v) -> System.out.println(k.getNomMission()+"  "+v));


		
		return res;
	}
	
//	public String convertWithStream(Map<Mission, Double> res) {
//	    String mapAsString = res.keySet().stream()
//	      .map(key -> key + "=" + res.get(key))
//	      .collect(Collectors.joining(", ", "{", "}"));
//	    System.out.println(mapAsString);
//	    return mapAsString;
//	}

	public double distance(Position pos1, Position pos2) {
		
		double long1 =0;
		
		double lat1= 0;
		
		double long2 = 0 ; 
		double lat2=0;
		
		for(Map.Entry<Double, Double> entry : pos1.getLonglatPos().entrySet()) {
			
			long1= entry.getKey();
			lat1 = entry.getValue();
			
		}
		
		for(Map.Entry<Double, Double> entry : pos2.getLonglatPos().entrySet()) {
			
			long2 = entry.getKey();
			lat2 = entry.getValue();
			
		}
		
		
//	
//		Double lat1 =  pos1.getLonglatPos().entrySet().stream().flatMap(x->x.getValue()) ;
//		
//		double lat2 =  pos2.getLonglatPos().entrySet().stream().flatMap(x->x.getValue()); 
		
//		double long1 = pos1.getLonglatPos().entrySet().stream().flatMap(x->x.getKey()); 
//		
//		double long2 = pos2.getLonglatPos().entrySet().stream().flatMap(x->x.getKey()); 
		
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    return result;  // 2 * R; R = 6371 km
	    
	    
	    
		 
	}

}
