package com.projet.annuaire.service;


import java.util.List;
import java.util.Optional;

import com.projet.annuaire.model.Tutor;

/**
 * 
 * @author MOKADDEM Mohamed
 *
 */

public interface TutorService {
	/**
	 * save tutor
	 * @param tutor tutor save
	 */
    void save(Tutor tutor);
    /**
     * update tutor with id
     * @param tutorForm tutor with new information
     * @param id tutor id update
     */
	void update(Tutor tutorForm, Long id);
	/**
	 * delete tutor by id
	 * @param id tutor id
	 */
	void deleteById(Long id);
	/**
	 * Search tutor by id
	 * @param id tutor id
	 * @return tutor find
	 */
	Tutor findById(Long id);
	/**
	 * Search all tutor
	 * @return list of all tutor
	 */
	List<Tutor> findAll();
	
}