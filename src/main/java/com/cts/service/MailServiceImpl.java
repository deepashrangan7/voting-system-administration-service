package com.cts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cts.model.Users;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailServiceImpl implements MailService{
	
	@Autowired
	private JavaMailSender javaMailSender;

	private String from = "deepashdeepika77@gmail.com";

	// account creation mail with password
	public boolean sendAccountCreationMail(Users user) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setSubject("Account Created Successfully");
		mailMessage.setFrom(from);

		try {

			String message = "Hello " + user.getName()
					+ "\n\n You Have been successfully registered with online voting system\n\nYour UserID is "
					+ user.getUserId() + "\n\nYour password is - " + user.getPassword()
					+ "\n\nReset your password once you logged in!!!";

			mailMessage.setText(message);
			mailMessage.setTo(user.getEmail());

			javaMailSender.send(mailMessage);

			return true;
		} catch (Exception e) {
			log.error("error while sending mail  {}", e.getMessage());
		}
		return false;
	}

}
