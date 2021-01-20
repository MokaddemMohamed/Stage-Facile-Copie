package com.projet.annuaire.repository;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Reply;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */

public interface ReplyRepository extends JpaRepository<Reply, Long>{
	/**
	 * Find reply by comment id ordering by date ascending
	 * @param id comment id
	 * @return replies found
	 */
	Set<Reply> findByCommentIdOrderByDateAsc(Long id);

	/**
	 * Delete by id
	 * @return stage delete
	 */
    void deleteById(Long id);
    
    /**
     * find by id
     * @return reply found
     */
    Optional<Reply> findById(Long id);
}