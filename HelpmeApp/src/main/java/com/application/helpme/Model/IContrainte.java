package com.application.helpme.Model;

@FunctionalInterface
public interface IContrainte <T> {
	
	
	
	
	
	default boolean and(Contrainte c) {
	
		return true;
	}

	boolean test(UserLocalise ul, Mission m, double b);
	



}
