package com.kcsajan.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/send")
	public String sendCustomEmail(@RequestBody Email email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getText());
		javaMailSender.send(message);
		return "Email send successfully to " + email.getTo();
	}
}
