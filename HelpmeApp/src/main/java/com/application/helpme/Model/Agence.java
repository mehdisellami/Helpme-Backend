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


	
	
//	public Map<Mission,Double> selectionner(Position depart ,Position arrivee){
//        Map <Mission,Double> resultat = new HashMap<Mission, Double>();
//        for (Mission m : listeMission) {
//            double d1 = distance(depart,m.getPos());
//            double d2 = distance(m.getPos(),arrivee);
//            double result=d1+d2;
//            System.out.println("La mission " + m.getNomMission() + " se trouve a " + d1 + " km de ma position et a " + result + " km de mon point d'arrivee");
//            
//            if(result <12) {
//            	System.out.println("Le nom de la mission pris " + m.getNomMission());
//            	   resultat.put(m, result);
//            	   
//          
//            	  
//            	
//            }
//            else {System.out.println("la les Mission est trop loin ");}
//            
//         
//        }
      //  resultat.forEach((k,v) -> System.out.println(k.getNomMission()+"  "+v));
//        return resultat;
//    }
	

//	public double distance(Position pos1, Position pos2) {
//		
//		double long1 =pos1.getLong();
//		
//		double lat1= pos1.getLat();
//		
//		double long2 =pos2.getLong() ; 
//		double lat2=pos2.getLat();
//		
//		double p = 0.017453292519943295;    // Math.PI / 180
//	    
//	    double a = 0.5- Math.cos((lat2 - lat1) * p)/2 + Math.cos(lat1 * p) * Math.cos(lat2 * p) * (1 - Math.cos((long2 - long1) * p))/2;
//	    		
//	    double result = Math.round( 12742 * Math.asin(Math.sqrt(a)));
//	    return result;  // 2 * R; R = 6371 km
//		 
//	}
	
	public double distance (UserLocalise ul , Mission m ) {
		return ul.distance(m);
	}
	
	
	public List<Mission> ListeMission(UserLocalise ul , double b){
		
		
		return listeMission.stream().filter(m -> distance(ul, m) <= b).collect(Collectors.toList());
		
		
	}
	
	public boolean estCompatible(UserLocalise userpref , Mission mpref) {
		
		boolean rtr=false;
		
		if (userpref.getUserPos().getPrefUser().isJeune() &&  mpref.getPrefMission().isJeune() ) {
			userpref.getUserPos().getPrefUser().accepte(mpref.getPrefMission());
			rtr = true;			
		}
		else if (userpref.getUserPos().getPrefUser().isVieux() &&  mpref.getPrefMission().isVieux() ) {	
			rtr = true;
		}
		return rtr;
	}

}
