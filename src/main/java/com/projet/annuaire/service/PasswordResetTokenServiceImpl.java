package com.projet.annuaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.PasswordResetToken;
import com.projet.annuaire.repository.PasswordResetTokenRepository;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {	
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;

	@Override
	public void save(PasswordResetToken token) {
		passwordResetTokenRepository.save(token);
	}

	@Override
	public PasswordResetToken findByConfirmationToken(String confirmationToken) {
		return passwordResetTokenRepository.findByConfirmationToken(confirmationToken);
	}

}
