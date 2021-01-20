package com.projet.annuaire.service;

import com.projet.annuaire.model.Comment;

public interface CommentService {
	/**
	 * save a comment
	 * @param comment comment to save
	 */
	void save(Comment comment);
	/**
	 * Delete comment by id
	 * @param id id of comment
	 */
	void deleteById(Long id);
	
	/**
	 * search by stage id
	 * @param id stage id
	 * @return comment found
	 */
	Comment findByStageId(long id);
}
