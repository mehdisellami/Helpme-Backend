package com.application.helpme;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.application.Model.User;


@EntityScan(basePackages = {"com.application.Model"})
@SpringBootApplication
public class HelpmeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpmeAppApplication.class, args);
		
		
		
	}

}
