package com.application.helpme.Model;

public class Info {

	
	User userInfo;

	public Info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Info(User userInfo) {
		super();
		this.userInfo = userInfo;
	}

	
	public boolean aime(User u1, User u2) { 
		
		boolean rtr=false;
		
	if (u1.getPrefUser().isJeune() &&  u2.getPrefUser().isJeune() ) {
		// Question : Alexis a 70 ans et qui aime Les jeunes == Chelson qui aime les Jeunes -> la mission crée alexis 
		//par Alexis va s'afficher pour chelson !
		
		rtr = true;
		
	}
	
	else if (u1.getPrefUser().isVieux() &&  u2.getPrefUser().isVieux() ) {
		
		
		rtr = true;
	}
	
//	else if (u1.getPrefUser().isVieux() &&  (u2.getPrefUser().isVieux() || u2.getPrefUser().isJeune() ) ) {
//		
//		
//		u1.getUserMissionCreateur();
//		rtr = true;
//	}
//	
//	else if (u1.getPrefUser().isJeune() &&  (u2.getPrefUser().isVieux() || u2.getPrefUser().isJeune() ) ) {
//	
//		u1.getUserMissionCreateur();
//		rtr = true;
//	}
	

		
		return rtr;
	}


	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}
	
	
	 
}
