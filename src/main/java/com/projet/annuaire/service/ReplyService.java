package com.projet.annuaire.service;

import java.util.Set;

import javax.transaction.Transactional;

import com.projet.annuaire.model.Reply;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
public interface ReplyService {
	/**
	 * save a reply
	 * @param comment comment to save
	 */
	void save(Reply reply);
	/**
	 * Delete reply by id
	 * @param id id of reply
	 */
	@Transactional
	void deleteById(Long id);
	
	/**
	 * find reply by id
	 * @param id
	 * @return reply found
	 */
	Reply findById(Long id);
	
	/**
	 * search by comment id ordering by date ascending
	 * @param id id comment
	 * @return replies found
	 */
	Set<Reply> findByCommentIdOrderByDateAsc(Long id);
}
