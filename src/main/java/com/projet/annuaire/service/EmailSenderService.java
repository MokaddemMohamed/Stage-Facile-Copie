package com.projet.annuaire.service;

import org.springframework.mail.SimpleMailMessage;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
public interface EmailSenderService {
	public void sendEmail(SimpleMailMessage email);
	
	public void prepareAndSendEmail(String mailAddress, String subject, String text);
}
