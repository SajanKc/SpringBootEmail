package com.kcsajan.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmailController {
	String emailReceiver = "sazankce@gmail.com";

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/sendemail")
	public String sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailReceiver);
		message.setSubject("Email sending from spring boot application");
		message.setText("Hello there! This is a demo text...");
		javaMailSender.send(message);
		return "Email sent successfully to " + emailReceiver;
	}
}
