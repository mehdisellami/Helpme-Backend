package com.application.helpme.controlleur;


import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.helpme.DAO.missionRepository;
import com.application.helpme.DAO.userRepository;
import com.application.helpme.Model.Mission;
import com.application.helpme.Model.User;
import com.application.helpme.Model.etatMission;
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
	@PreAuthorize("hasRole('ADMIN')")
	public String RestApi() {
		return "HelpME Application Université Paris Nanterre";
	}

	
	
	@PostMapping("/newmission")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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
	
	@DeleteMapping("/deletemission/{idMission}")
    public Boolean deleteMission(@PathVariable long idMission) {
         mr.deleteById(idMission);
         return true ;
    }
	
	
	

	@PostMapping("/newuser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
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
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<Mission> findProjet() {
		return  mr.findAll();
	
	
}
	
	@GetMapping("/listeUser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<User> findUser() {
		return  ur.findAll();
	
	
}

	
	@GetMapping("/Login/{username}/{password}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String loginUser(@PathVariable String username, @PathVariable String password) {
		
		 ur.finduserByuserNameandPassword(username , password);
		 return String.format("L'utilisateur %s est Connecté", username);
			
}

}
