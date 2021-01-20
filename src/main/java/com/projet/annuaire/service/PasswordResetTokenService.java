package com.projet.annuaire.service;

import com.projet.annuaire.model.PasswordResetToken;

public interface PasswordResetTokenService {
	/**
	 * save token
	 * @param token	token to save
	 */
    void save(PasswordResetToken token);
    
    /**
     * find PasswordResetToken by string ConfirmationToken
     * @param confirmationToken
     * @return PasswordResetToken found
     */
    PasswordResetToken findByConfirmationToken(String confirmationToken);
}