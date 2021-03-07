package com.application.helpme.Model;

public class Email {
	private String email;
	private String subject;
	private String message;
	
	public Email(String e, String s, String m) {
		this.email=e;
		this.subject=s;
		this.message=m;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}