package com.application.helpme.controlleur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class Controlleur {

	
	@GetMapping("/test")
	public String RestApi() {
		return "HelpME Application Université Paris Nanterre";
	}
}
