package com.altimetrik.challenge.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.altimetrik.challenge.model.Comment;
import com.altimetrik.challenge.model.Customer;


@Service
public class MailSendService {
	
	
private JavaMailSender javaMailSender;
	
	@Autowired
	public MailSendService(JavaMailSender javaMailSender){
		this.javaMailSender = javaMailSender;
	}
	
	@Async
	public void sendNotificaitoin(Comment cmt) throws MailException, InterruptedException {
		
		Customer user = new Customer();
		
		System.out.println("Sleeping now...");
        Thread.sleep(10000);
		
        System.out.println("Sending email...");
        
        SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmail());
		mail.setFrom("kesavulu.java.se@gmail.com");
		mail.setSubject("Answer is awesome!");
		mail.setText("Answer");
		javaMailSender.send(mail);
		
		System.out.println("Email Sent!");
	}
	
}