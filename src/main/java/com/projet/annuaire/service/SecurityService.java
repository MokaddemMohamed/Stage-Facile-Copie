package com.projet.annuaire.service;

public interface SecurityService {
	
	/**
	 * Log by username
	 * @return
	 */
    String findLoggedInUsername();
    /**
     * active user find
     * @return username 
     */
    String findLoggedInUser();
    /**
     * login 
     * @param username user username
     * @param password user password
     */
    void autoLogin(String username, String password);
}