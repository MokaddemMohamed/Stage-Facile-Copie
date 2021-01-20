package com.projet.annuaire.service;

import java.util.Set;

import com.projet.annuaire.model.Vote;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
public interface VoteService {
	/**
	 * save a vote
	 * @param vote comment to save
	 */
	void save(Vote vote);
	/**
	 * Delete vote by id
	 * @param id id of comment
	 */
	void deleteById(Long id);
	
	/**
	 * Delete votes by reply id
	 * @param id
	 */
	void deleteByReplyId(Long id);
	
	/**
	 * search votes by reply id
	 * @param id reply id
	 * @return list of vote found
	 */
	Set<Vote> findByReplyId(Long id);
	
	/**
	 * search vote by reply and user id
	 * @param id1	reply id
	 * @param id2	user id
	 * @return vote found
	 */
	Vote findByReplyIdAndUserId(Long id1, Long id2);
}
