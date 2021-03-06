package com.application.helpme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.application.helpme.Model"})
public class HelpmeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpmeAppApplication.class, args);
	}

}
