package com.application.helpme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.application.helpme.Model.Agence;
import com.application.helpme.Model.Info;
import com.application.helpme.Model.Mission;
import com.application.helpme.Model.Position;
import com.application.helpme.Model.Pref;
import com.application.helpme.Model.User;


@EntityScan(basePackages = {"com.application.helpme.Model"})
//@ComponentScan("com.application.helpme.controlleur")


@SpringBootApplication
public class HelpmeAppApplication extends SpringBootServletInitializer {
	
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	         return application.sources(HelpmeAppApplication .class);
	    }

	
		
	public static void main(String[] args) {
		SpringApplication.run(HelpmeAppApplication.class, args);
		
		Map<Double, Double> longlatMaPosition = new HashMap<Double, Double>();
		longlatMaPosition.put(2.390055, 48.8077584);

		Position positonUser = new Position(longlatMaPosition);

		
		Map<Double, Double> longlatMission = new HashMap<Double, Double>();
		longlatMission.put(2.3794244, 48.8073919);
		
		Map<Double, Double> longlatMission2 = new HashMap<Double, Double>();
		longlatMission2.put(2.3500595, 48.862501);
		
		Map<Double, Double> longlatMission3 = new HashMap<Double, Double>();
		longlatMission3.put(2.2133373, 48.903165);
		
		
		
		Position p1 = new Position(longlatMission);
		
		Position p2 = new Position(longlatMission2);
		
		Position p3 = new Position(longlatMission3);
				
	
		Mission m1 = new Mission(1, "Partir à Carrefour Market", "22 Promenée Marat, 94200 Ivry-sur-Seine",  p1);
		
		Mission m2 = new Mission(2, "Partir à falafel café", "176 Rue Saint Martin 75003",  p2);
		
		Mission m3 = new Mission(3, " Nanterre", "Université Paris Nanterre",  p3);
		
		Pref prefJeune =new Pref(true);
			
		Pref prefJeune2 =new Pref(true);
		
		Pref vieuPref =new Pref();
		
		User u1 = new  User(1, "Mehdi SELLAMI", positonUser,prefJeune,m2);
		
		
		
		
		User u2 = new  User(2, "Alexis Sidate", positonUser,vieuPref);
		
		User u3 = new  User(1, "Chelson Supreme", positonUser,vieuPref,m1);
		
		List <Mission> listeMission = Arrays.asList(u1.getUserMissionCreateur(),u3.getUserMissionCreateur());
	
		
		Agence agenceChercher = new Agence();
				
		agenceChercher.setListeMission(listeMission);
		
		Info infoUserMatchMission = new Info();
		
		if (infoUserMatchMission.aime(u1,u2)) {
			
			agenceChercher.selectionner(u2, positonUser);
		}
		
		
		if (infoUserMatchMission.aime(u3,u2)) {
					
			agenceChercher.selectionner(u2, positonUser);
				}
		
		
		
		
		
	}

}
