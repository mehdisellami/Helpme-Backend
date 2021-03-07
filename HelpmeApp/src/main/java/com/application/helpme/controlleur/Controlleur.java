package com.application.helpme.controlleur;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.application.helpme.DAO.missionRepository;
import com.application.helpme.DAO.userRepository;
import com.application.helpme.Model.Email;
import com.application.helpme.Model.FeedbackMission;
import com.application.helpme.Model.Mission;
import com.application.helpme.Model.User;
import com.application.helpme.Model.etatMission;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController

public class Controlleur {
	
	@Autowired
	missionRepository mr;
	
	@Autowired
	userRepository ur;
	
	String nl = System.getProperty("line.separator");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@RequestMapping(value = "/email", method = RequestMethod.POST, consumes = "application/json")
	public void sendEmail(@RequestBody Email emailModel) {
		LOGGER.info("Sending email");
		
		MimeMessage mail = javaMailSender.createMimeMessage();
		try {
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo("sidatealexis@gmail.com");
		//helper.setFrom(emailModel.getEmail());
		helper.setSubject(emailModel.getSubject());
		helper.setText(emailModel.getMessage());
		} catch (MessagingException e) {
		LOGGER.error("Failed to send email: " + emailModel.toString(), e);
		} finally {}
		javaMailSender.send(mail);
	}
	
	@GetMapping("/test")
	@PreAuthorize("hasRole('ADMIN')")
	public String RestApi() {
		return "HelpME Application Université Paris Nanterre";
	}

	
	@PostMapping("/newmission")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public Mission addNewMission(@Valid  @RequestBody Mission m) {
		
		Mission dem = new Mission(m.getNomMission(),m.getAdressMission(),m.getDateMission(),m.getDescription(),m.getStatusMission(),m.getFeedbackNote(),m.getUserMission());
		
		String messagemail = "Votre mission a bien été créée, voici les informations de celle-ci" + nl + nl + "Nom de la mission :" + m.getNomMission() + nl + "Adresse de la mission : "+
				m.getAdressMission() + nl +"Date de la mission : " + m.getDateMission() + nl + "Description : " + m.getDescription() + ".";
		Email e = new Email("sidatealexis@gmail.com","Création de la mission " + m.getNomMission() , messagemail);
		//Email e = new Email(m.getUserMission().getEmail(),"Création de mission", messagemail);
		sendEmail(e);
		
        return 	mr.save(dem);
	}
	
	@GetMapping("/getmission/{idMission}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized Mission GetMission(@PathVariable int idMission) {
		Mission x = mr.findById(idMission).get();
		return x;
	}
	
	@PostMapping("/editmission")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized Mission editMission(@Valid  @RequestBody Mission m) {
		Mission x = mr.findById(m.getIdMission()).get();
		x.setNomMission(m.getNomMission());
		x.setDateMission(m.getDateMission());
		x.setAdressMission(m.getAdressMission());
		x.setDescription(m.getDescription());
		
		String messagemail = "Votre mission a bien été modifiée, voici les nouvelles informations de celle-ci" + nl + nl + "Nom de la mission :" + m.getNomMission() + nl + "Adresse de la mission : "+
				m.getAdressMission() + nl +"Date de la mission : " + m.getDateMission() + nl + "Description : " + m.getDescription() + ".";
		Email e = new Email("sidatealexis@gmail.com","Modification de la mission " + m.getNomMission() , messagemail);
		//Email e = new Email(m.getUserMission().getEmail(),"Modification de la mission" + m.getNomMission() , messagemail);
		sendEmail(e);
		
		return mr.save(x);
	}
	
	@DeleteMapping("/deletemission/{idMission}")
    public Boolean deleteMission(@PathVariable int idMission) {
		Mission x = mr.findById(idMission).get();

        String messagemail = "Votre mission " + x.getNomMission() + " a bien été supprimée";
 		Email e = new Email("sidatealexis@gmail.com","Suppression de la mission " + x.getNomMission() , messagemail);
 		//Email e = new Email(x.getUserMission().getEmail(),"Création de mission", messagemail);
 		sendEmail(e);
 		
 		mr.deleteById(idMission);
         return true ;
    }
	
	@PostMapping("/newuser")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	public User addNewUser(@Valid  @RequestBody User u  ) {
		User usr = new User(u.getName(),u.getUsername(),u.getEmail(),u.getPassword(),u.getTel());
		
		String messagemail = "Votre compte HelpMe a bien été créé"+ nl + "Identifiant :" + u.getUsername() ;
 		Email e = new Email("sidatealexis@gmail.com","Nouveau compte HelpMe ", messagemail);
 		//Email e = new Email(u.getEmail(),"Nouveau compte HelpMe ", messagemail);
 		sendEmail(e);
		return 	ur.save(usr);
	}
	
	@GetMapping("/listeMission")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<Mission> findProjet() {
		return  mr.findAll();	
	}
	
	@GetMapping("/listeMissionEnAttente")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public Iterable<Mission> findMissionAttente() {
		return  mr.findMissionenAttente();
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
	
	@GetMapping("/findidUserbyUsername/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public int findIDuserByusername(@PathVariable String username) {
		return ur.findIDuserByusername(username );
	}
	
	@GetMapping("/findUserbyUsername/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<User> finduserByusername(@PathVariable String username) {
		return ur.findUserByUsername(username);
	}
	
	@GetMapping("/findUserMissionHistory/{username}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public List<Mission> findUserMissionHistory(@PathVariable String username) {
		return mr.findUserMissionHistory(username);
	}
	
	@PutMapping("/affecterUserMission/{iduser}/{idmission}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized  Mission  affecterUserMission(@PathVariable int iduser  , @PathVariable  int idmission) {
		Mission x = mr.findById(idmission).get();
		x.setUserMission(ur.findById(iduser).get());
		x.setStatusMission(etatMission.ACCEPTE);
		
		String messagemail = "Votre mission " + x.getNomMission() + " a été prise en charge par ";
 		Email e = new Email("sidatealexis@gmail.com","Votre mission " + x.getNomMission() + " a été acceptée", messagemail);
 		//Email e = new Email(x.getUserMission().getEmail(),"Nouveau compte HelpMe ", messagemail);
 		sendEmail(e);
 		
		return	mr.save(x);	
	}
	
	@PutMapping("/Missiontermine/{idmission}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized  Mission  terminerMission( @PathVariable  int idmission) {
		Mission x = mr.findById(idmission).get();
		x.setStatusMission(etatMission.Termine);
		return	mr.save(x);
	} 

	@PutMapping("/feedBackMission/{idmission}/{IdNoteMission}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized  Mission  feedBackMission( @PathVariable  int idmission , @PathVariable  int IdNoteMission ) throws Exception {
		Mission x = mr.findById(idmission).get();
		if (IdNoteMission == 1 && x.getStatusMission().equals(etatMission.Termine)) {
			x.setFeedbackNote(FeedbackMission.ETOILE1);
		}
		else if (IdNoteMission == 2 && x.getStatusMission().equals(etatMission.Termine)) {
			x.setFeedbackNote(FeedbackMission.ETOILE2);
		}
		else if (IdNoteMission == 3  && x.getStatusMission().equals(etatMission.Termine)) {
			x.setFeedbackNote(FeedbackMission.ETOILE3);
		}
		else if (IdNoteMission == 4 && x.getStatusMission().equals(etatMission.Termine)) {
			x.setFeedbackNote(FeedbackMission.ETOILE4);
		}
		else if (IdNoteMission == 5 && x.getStatusMission().equals(etatMission.Termine)) {
			x.setFeedbackNote(FeedbackMission.ETOILE5);
		}
		else {
			throw new Exception  ("Désolé, la mission n'est pas termineé") ;
		}
		
		String messagemail = "Vous a attribué une note de " + IdNoteMission + " sur 5 pour la mission" + x.getNomMission() ;
 		Email e = new Email("sidatealexis@gmail.com","Feedback mission" + x.getNomMission(), messagemail);
 		//Email e = new Email(x.getUserMission().getEmail(),"Nouveau compte HelpMe ", messagemail);
 		sendEmail(e);
 		
		return	mr.save(x);
	} 

	@PutMapping("/mettreunCommentaire/{idmission}")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public synchronized  Mission  modifierCommentaire( @PathVariable  int idmission , @RequestBody Mission m) {
		Mission x = mr.findById(idmission).get();
		x.setCommentaire(m.getCommentaire());
		
		String messagemail = "Vous avez recu un nouveau commentaire pour la mission " + x.getNomMission() + " : " + nl + nl + x.getCommentaire();
 		Email e = new Email("sidatealexis@gmail.com","Feedback mission" + x.getNomMission(), messagemail);
 		//Email e = new Email(x.getUserMission().getEmail(),"Nouveau compte HelpMe ", messagemail);
 		sendEmail(e);
		return	mr.save(x);
	}
}
