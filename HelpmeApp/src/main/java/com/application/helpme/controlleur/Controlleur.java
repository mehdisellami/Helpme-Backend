package com.application.helpme.controlleur;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.Model.Mission;
import com.application.Model.User;
import com.application.Model.etatMission;
import com.application.helpme.DAO.missionRepository;
import com.application.helpme.DAO.userRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class Controlleur {
	
	@Autowired
	missionRepository mr;
	
	@Autowired
	userRepository ur;

	
	@GetMapping("/test")
	public String RestApi() {
		return "HelpME Application Université Paris Nanterre";
	}

	
	
	@PostMapping("/newmission")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public Mission addNewMission(@Valid  @RequestBody Mission m  ) {
		
		Mission dem = new Mission();
		
		dem.setNomMission(m.getNomMission());
		dem.setAdressMission(m.getAdressMission());
		dem.setDateMission(m.getDateMission());
		dem.setDescription(m.getDescription());
		dem.setUserMission(m.getUserMission());
		
	

		return 	mr.save(dem);
		
		
		
	}
	
	

	@PostMapping("/newuser")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public User addNewUser(@Valid  @RequestBody User u  ) {
		
		User usr = new User();
		
		usr.setUsername(u.getUsername());
		usr.setName(u.getName());
		usr.setPassword(u.getPassword());
		usr.setEmail(u.getEmail());
		
		usr.setTel(u.getTel());
		return 	ur.save(usr);
		
		
	}
	
	
	@GetMapping("/listeMission")
	public Iterable<Mission> findProjet() {
		return  mr.findAll();
	
	
}
	
	@GetMapping("/listeUser")
	public Iterable<User> findUser() {
		return  ur.findAll();
	
	
}
	
	


}
