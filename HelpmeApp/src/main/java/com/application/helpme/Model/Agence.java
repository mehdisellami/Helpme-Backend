package com.application.helpme.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;

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


	
	
	public List<Mission> selectionner(Position depart ,Position arrivee){
        List<Mission> resultat = new ArrayList<Mission>();
        for (Mission m : listeMission) {
        	Position posMission = new Position(2.3500595, 48.862501);
        	m.setPos(posMission);
        	
            double d1 = distance(depart,m.getPos());
            double d2 = distance(m.getPos(),arrivee);
            double result=d1+d2;
            System.out.println("La mission " + m.getNomMission() + " se trouve a " + d1 + " km de ma position et a " + result + " km de mon point d'arrivee");
            
            resultat.add(m);
            
         
        }
      //  resultat.forEach((k,v) -> System.out.println(k.getNomMission()+"  "+v));
        return resultat;
    }
	


	
	public double distance (Position pos1 , Position pos2 ) {
		double long1 = pos1.getLong();
		
		
		double lat1= pos1.getLat();
		
		double long2 =pos2.getLong();
		double lat2=pos2.getLat();
	
		
		double p = 0.017453292519943295;    // Math.PI / 180
	    
	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
	    		
	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
	    
	    System.out.println("Methode distance classe Agence lancé");
	    return result;  // 2 * R; R = 6371 km	
	}
	
	
	public List<Mission> ListeMission(UserLocalise ul , double b){
		
		return null;
		//return listeMission.stream().filter(m -> distance(ul, m) <= b).collect(Collectors.toList());
		
		
	}
	
	public List<Mission> estCompatible( User userpref,  List<Mission>mpref ,Position depart , Position arrivee) {
		boolean rtr=false;
		
		List<Mission> resultat = new ArrayList<Mission>();
		
		for (Mission m : mpref) {
			 Pref p = new Pref();
			if (p.accepte(userpref, m) && m.getStatusMission().equals(etatMission.ENATTENTE)) {
				
				Position posMission = new Position(2.3500595, 48.862501);
	        	m.setPos(posMission);
	        	
	            double d1 = distance(depart,m.getPos());
	            m.setDistanceUserMission(d1);
	            double d2 = distance(m.getPos(),arrivee);
	            m.setMissionPointArrivee(d2);
	            double result=d1+d2;
	            System.out.println("La mission " + m.getNomMission() + " se trouve a " + d1 + " km de ma position et a " + result + " km de mon point d'arrivee");
	            
	            resultat.add(m);
	        
				
			}
			
			
			
		}
		
		return resultat;
		
	}
	
	public <T> List<Mission> findMission(UserLocalise ul , Contrainte  c , double v){
		
		return listeMission.stream()
				.filter(m -> c.test(ul, m, v))
				.collect(Collectors.toList());
		
	}
	

}
