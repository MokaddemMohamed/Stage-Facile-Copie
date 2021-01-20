package com.projet.annuaire.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Vote;
/**
 * 
 * @author SCHAETZEL Robin
 *
 */
public interface VoteRepository extends JpaRepository<Vote, Long>{
	
	/**
	 * find votes by reply id
	 * @param id
	 * @return votes found
	 */
	Set<Vote> findByReplyId(Long id);
	
	/**
	 * delete votes by reply id
	 * @param id
	 */
	void deleteByReplyId(Long id);
	
	/**
	 * find vote by reply id and user id
	 * @param id1	reply id
	 * @param id2	user id
	 * @return
	 */
	Vote findByReplyIdAndUserId(Long id1, Long id2);
}