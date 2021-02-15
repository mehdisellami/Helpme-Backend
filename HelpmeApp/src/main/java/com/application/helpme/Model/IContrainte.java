package com.application.helpme.Model;

@FunctionalInterface
public interface IContrainte <T> {
	
	
	
	boolean test(UserLocalise ul , Mission m  , T i);
	
	Contrainte and  (Contrainte c);


}
