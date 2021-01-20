package com.projet.annuaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.projet.annuaire.model.Tutor;

/**
 * 
 * @author MOKADDEM Mohamed 
 *
 */

public interface TutorRepository extends JpaRepository<Tutor, Long>{
	/**
	 * search tutor with its id
	 * @param id entity id
	 * @return tutor found
	 */
    Optional<Tutor> findById(Long id);
	/**
	 * Create a list of all tutor
	 */
    List <Tutor> findAll();
    /**
     * Delete tutor with id
     * @return tutor delete
     */
    @Query("delete FROM Tutor u where id=?1")
    Tutor deleteById();
    /**
     * Find tutor by mail
     * @param Mail tutor mail
     * @return tutor find
     */
    Tutor findByMail(String Mail);
    /**
     * Find tutor by number
     * @param number tutor number
     * @return tutor find
     */
    Tutor findByPhoneNumber(String number);
    
	/** 
	 * truncate table tutor
	 */
	@Transactional
	@Modifying
	@Query("delete from Tutor")
    void deleteTutor();
}
    