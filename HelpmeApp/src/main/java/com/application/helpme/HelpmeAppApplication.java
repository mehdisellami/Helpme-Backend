package com.application.helpme;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import com.application.helpme.Model.User;


@EntityScan(basePackages = {"com.application.helpme.Model"})
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
