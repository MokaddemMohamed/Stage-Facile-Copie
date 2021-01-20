package com.projet.annuaire.service;

import java.util.List;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.model.Stage;
/**
 * 
 * @author MOKADDEM Mohamed
 *
 */

public interface StageService {
	
	/**
	 * Save stage
	 * @param stage stage save
	 */
    void save(Stage stage);
    /**
     * update stage with id
     * @param stageForm stage with new information
     * @param id stage id update
     */
	void update(Stage stageForm, Long id);
	/**
	 * Delete by id
	 * @param id stage id
	 */
	void deleteById(Long id);
	/**
	 * Find by enterprise id
	 * @param id enterprise id
	 * @return list stage find by enterprise id
	 */
	List<Stage> findByEnterpriseId(Long id);
	
	/**
	 * Save a comment
	 * @param stageForm stage find
	 * @param comment comment create
	 */
	void saveComment(Stage stageForm, Comment comment);
	/**
	 * Find all stage
	 * @return
	 */
	List <Stage> findAll();
	/**
	 * search stage by id
	 * @param id stage id
	 * @return stage find
	 */
	Stage findById(Long id);
	/**
	 * search by administrator
	 * @param string administrator name
	 * @return list of stage find
	 */
	List <Stage> findByAdministrator(String string);
	/**
	 * search by user id
	 * @param id user id
	 * @return list of stage find
	 */
	List <Stage>  findByUserId(Long id);
}