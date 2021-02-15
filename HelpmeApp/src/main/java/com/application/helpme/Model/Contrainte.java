package com.application.helpme.Model;

public class  Contrainte  <T> implements IContrainte<T> {
	
	Agence agence;

	@Override
	public boolean test (UserLocalise ul, Mission m, T x) {
		boolean rtr=false;
		
		if((boolean) x ) {
			agence.estCompatible(ul, m);
			rtr=true;
		}
		else rtr= false;
		
		return rtr;
	}

}
