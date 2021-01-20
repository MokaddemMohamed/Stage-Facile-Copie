package com.projet.annuaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Service("emailSenderService")
public class EmailSenderServiceImpl implements EmailSenderService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailSenderServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	/**
	 * Send email with param email
	 * @param email 	SimpleMailMessage to be sent
	 */
	@Async
	public void sendEmail(SimpleMailMessage email) {
		javaMailSender.send(email);
	}

	/**
	 * Prepare and send email
	 * @param mailAddress	receiver mail address
	 * @param subject 		subject of the mail
	 * @param text			mail content
	 */
	@Async
	public void prepareAndSendEmail(String mailAddress, String subject, String text) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(mailAddress);
		mailMessage.setSubject(subject);
		mailMessage.setFrom("amu.stagefacile@gmail.com");
		mailMessage.setText(text);
		sendEmail(mailMessage);
	}
}