package com.projet.annuaire.service;

import java.util.List;

import com.projet.annuaire.model.User;

public interface UserService {
	/**
	 * save user
	 * @param user user save
	 */
    void save(User user);
    /**
     * search by username
     * @param username user username
     * @return
     */
    User findByUsername(String username);
    /**
     * update by username
     * @param user user with new information
     * @param name username update
     */
    void update (User user,String name);
	User findByMail(String mail);
    /**
     * search by number
     * @param tel user number
     * @return user find by number
     */
    User findBytel(String tel);
    /**
     * search by firstName
     * @param first_name
     * @return user find by firstName
     */
    User findByFirstName(String first_name);
    /**
     * search by lastName
     * @param last_name user Lastname
     * @return user find by lastName
     */
    User findByLastName(String last_name);
    
    /**
     * Search all user
     * @return list of all tutor
     */
	List<User> findAll();
}