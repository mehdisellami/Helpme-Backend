package com.application.helpme;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.application.Model.User;


@EntityScan(basePackages = {"com.application.Model"})
@ComponentScan({"com.application.lookek.controlleur"})
@SpringBootApplication
public class HelpmeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpmeAppApplication.class, args);
		
		
		
	}

}
