package com.projet.annuaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.model.Stage;

/**
 * 
 * @author LE Dan
 *
 */

public interface CommentRepository extends JpaRepository<Comment, Long>{
	/**
	 * Find comment by stage id
	 * @param id stage id
	 * @return comment find
	 */
	Comment findByStageId(long id);
	
	/**
	 * Delete by id
	 * @return number of deleted comments
	 */
    void deleteById(Long id);
}