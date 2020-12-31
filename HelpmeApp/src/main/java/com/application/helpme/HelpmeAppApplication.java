package com.application.helpme;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.application.Model.User;


@EntityScan(basePackages = {"com.application.Model"})
@ComponentScan("com.application.helpme.controlleur")
@SpringBootApplication
public class HelpmeAppApplication extends SpringBootServletInitializer {
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	         return application.sources(HelpmeAppApplication .class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(HelpmeAppApplication.class, args);
		
		
		
	}

}
