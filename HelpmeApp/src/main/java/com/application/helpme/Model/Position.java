package com.application.helpme.Model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Position {

	
	private Map<Double,Double> longlatPos = new HashMap();
	
	public Position() {
		
	}

	
	public Position(Map<Double, Double> longlatPos) {
		super();
		this.longlatPos = longlatPos;
	}

	public Map<Double, Double> getLonglatPos() {
		return longlatPos;
	}

	public void setLonglatPos(Map<Double, Double> longlatPos) {
		this.longlatPos = longlatPos;
	}


	
	
	

	
	
}
