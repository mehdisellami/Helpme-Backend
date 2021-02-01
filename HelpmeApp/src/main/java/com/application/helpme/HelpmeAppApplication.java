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
		
		//Creation Map ma Position , position de Alexis , ou on veut aller
		Map<Double, Double> longlatMaPosition = new HashMap<Double, Double>();
		longlatMaPosition.put(2.390055, 48.8077584);
		
		Map<Double, Double> longlatAlexisSidate = new HashMap<Double, Double>();
		longlatAlexisSidate.put(2.200134, 48.92714);
		
		
		Map<Double, Double> longlatBaAdja = new HashMap<Double, Double>();
		longlatBaAdja.put(1.802980, 48.988320);
		
		
		Map<Double, Double> longlatOuJeveuxAller = new HashMap<Double, Double>();
		longlatOuJeveuxAller.put(2.2437287, 48.8359862);

		//Creation des Positions 
		Position positonUser = new Position(longlatMaPosition);
		
		Position positionAlexisSidate = new Position(longlatAlexisSidate);
		
		Position positionBaAdja = new Position(longlatBaAdja);
		
		Position positionOujeveuxaller = new Position(longlatOuJeveuxAller);

		
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
		
		Pref vieuxPref2 =new Pref();
		
		User u1 = new  User();
		u1.setId(1);
		u1.setName("Mehdi SELLAMI");
		u1.setPos(positonUser);
		u1.setPrefUser(prefJeune);
		u1.setUserMissionCreateur(m1);
		
		
		
		
		User u2 = new  User();
		u2.setId(2);
		u2.setName("Alexis Sidate");
		u2.setPos(positionAlexisSidate);
		u2.setPrefUser(prefJeune2);
		
		
		
		User u3 = new  User();
		u3.setId(3);
		u3.setName("Chelson Supreme");
		u3.setPrefUser(vieuPref);
		u3.setUserMissionCreateur(m2);
		
		User u4= new User();
		u4.setId(4);
		u4.setName("Ba Adja");
		u4.setPos(positionBaAdja);
		u4.setPrefUser(vieuxPref2);
		
		List <Mission> listeMission = Arrays.asList(u1.getUserMissionCreateur(),u3.getUserMissionCreateur());
	
		
		Agence agenceChercher = new Agence();
				
		agenceChercher.setListeMission(listeMission);
		
		Info infoUserMatchMission = new Info();
		
		if (infoUserMatchMission.aime(u3,u4)) {
			
			agenceChercher.selectionner(u4.getPos(), positionOujeveuxaller);
		}
		
		
	
		
		
		
		
	}

}
