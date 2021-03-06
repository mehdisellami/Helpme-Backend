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
import com.application.helpme.Model.GeoElement;
import com.application.helpme.Model.Info;
import com.application.helpme.Model.Mission;
import com.application.helpme.Model.Position;
import com.application.helpme.Model.Pref;
import com.application.helpme.Model.User;
import com.application.helpme.Model.UserLocalise;


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
		

		//Creation des Positions 
		Position positonUser = new Position(2.390055,48.8077584);
		
		Position positionAlexisSidate = new Position(2.200134,48.92714);
		
		Position positionBaAdja = new Position(1.802980,48.988320);
		
		Position positionOujeveuxaller = new Position(2.2437287,48.8359862);
	
	
		//Position des missions
		Position p1 = new Position(2.3794244,48.8073919);
		
		Position p2 = new Position(2.3500595,48.862501);
		
		Position p3 = new Position(2.2133373,48.903165);
		
		Pref prefJeune =new Pref(true);
		
		Pref prefJeune2 =new Pref(true);
		
		Pref vieuPref =new Pref();
		
		Pref vieuxPref2 =new Pref();
				
	
		Mission m1 = new Mission(1, "Partir à Carrefour Market", "22 Promenée Marat, 94200 Ivry-sur-Seine",  p1);
		
		Mission m2 = new Mission(2, "Partir à falafel café", "176 Rue Saint Martin 75003",  p2);
		
		Mission m3 = new Mission();
		m3.setIdMission(3);
		m3.setNomMission("Nanterre");
		m3.setAdressMission("Université Paris Nanterre");
		m3.setPos(p3);
		m3.setPrefMission(prefJeune2);
		
		
		
		
		User u1 = new  User();
		u1.setId(1);
		u1.setName("Mehdi SELLAMI");
		u1.setPos(positonUser);
		u1.setPrefUser(prefJeune);
		u1.setUserMissionCreateur(m1);
		
		
		UserLocalise u1Localise = new UserLocalise();
		u1Localise.setUserPos(u1);
		
		
		
		User u2 = new  User();
		u2.setId(2);
		u2.setName("Alexis Sidate");
		u2.setPos(positionAlexisSidate);
		u2.setPrefUser(prefJeune2);
		
		
		
		User u3 = new  User();
		u3.setId(3);
		u3.setName("Chelson Supreme");
		u3.setPrefUser(prefJeune2);
		u3.setUserMissionCreateur(m2);
		
		User u4= new User();
		u4.setId(4);
		u4.setName("Ba Adja");
		u4.setPos(positionBaAdja);
		u4.setPrefUser(prefJeune2);
		
		
		UserLocalise u4Localise = new UserLocalise();
			u4Localise.setUserPos(u4);
		
		List <Mission> listeMission = Arrays.asList(u1.getUserMissionCreateur(),u3.getUserMissionCreateur());
	
		
		Agence agenceChercher = new Agence();
				
		agenceChercher.setListeMission(listeMission);
		

	
		
		agenceChercher.estCompatible(u1Localise, m3);
		
		GeoElement g1 = new GeoElement();
		g1.setMissionLocalise(m3);
		g1.setUserLocalise(u1Localise);
		
		
	//	System.out.println(agenceChercher.distance(u1Localise, m3));
	
		
	}

}
