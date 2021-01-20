package com.projet.annuaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.transaction.annotation.Transactional;


import com.projet.annuaire.model.Stage;

/**
 * 
 * @author MOKADDEM Mohamed
 * @author LE Dan 
 *
 */

public interface StageRepository extends JpaRepository<Stage, Long>{

	/**
	 * search stage with its id
	 * @param id entity id
	 * @return stage found
	 */
    Optional<Stage> findById(Long id);
    /**
     * create a list and add all stages
     */
    List <Stage> findAll();
    
    /**
     * Delete stage with id
     * @return stage delete
     */
    @Query("delete FROM Stage u where id=?1")
    Stage deleteById();
    /**
     * Search by enterprise id
     * @param id enterprise id
     * @return stage find by  enterprise id
     */
	List<Stage> findByEnterpriseId(Long id);
	
	@Transactional
	@Modifying
	@Query("update Stage set comment_id = ?1 where id=?2")
	void updateComment(long id1, long id2);
	/**
	 * Search by user id
	 * @param id user id
	 * @return stage find by yser id
	 */
	List <Stage> findByUserId(long id);
	
	/**
	 * Search by subject
	 * @param string subject
	 * @return Stage find by subject
	 */
	Stage findBySubject(String string);
	
	/**
	 * search by administrator name
	 * @param string administrator name
	 * @return stage find by administrator
	 */
	List <Stage> findByAdministrator(String string);
	
	/**
	 * truncate table stage
	 */
	@Transactional
	@Modifying
	@Query("delete from Stage")
    void deleteStage();
}