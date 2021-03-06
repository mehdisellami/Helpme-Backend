package com.application.helpme.controlleur;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.helpme.Model.Email;

@RestController
public class EmailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailController.class);
	
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
		helper.setReplyTo(emailModel.getEmail());
		helper.setFrom(emailModel.getEmail());
		helper.setSubject(emailModel.getSubject());
		helper.setText("From: " + emailModel.getUsername() + "\n" + emailModel.getMessage());
		} catch (MessagingException e) {
		LOGGER.error("Failed to send email: " + emailModel.toString(), e);
		} finally {}
		javaMailSender.send(mail);
	}
}
