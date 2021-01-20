package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.User;


/**
 * 
 * @author LE Dan
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{
	/**
	 * search user with his username
	 * @param username entity username
	 * @return user found
	 */
    User findByUsername(String username);
   
    /**
	 * search user with his email
	 * @param username entity email
	 * @return user found
	 */
    User findByMail(String mail);
    
    /**
     * create a list and add all user
     */
    List <User> findAll();
    /**
     * Find by number
     * @param tel number phone
     * @return User
     */
	User findByTel(String tel);
	
	/**
	 * Find by last_name
	 * @param first_name user firstName
	 * @return User
	 */
	User findByFirstName(String first_name);
	/**
	 * Find by last_name
	 * @param last_name user lastName
	 * @return User
	 */
	User findByLastName(String last_name);
}