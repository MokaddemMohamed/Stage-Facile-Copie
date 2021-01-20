package com.projet.annuaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.PasswordResetToken;
/**
 * 
 * @author SCHAETZEL Robin
 *
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {
	PasswordResetToken findByConfirmationToken(String confirmationToken);
}
