package com.projet.annuaire.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Vote;
import com.projet.annuaire.repository.VoteRepository;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Service
public class VoteServiceImpl implements VoteService {

	@Autowired
	VoteRepository voteRepository;
	
	@Override
	public void save(Vote vote) {
		voteRepository.save(vote);
	}

	@Override
	public void deleteById(Long id) {
		voteRepository.deleteById(id);
	}

	@Override
	public Set<Vote> findByReplyId(Long id) {
		return voteRepository.findByReplyId(id);
	}

	@Override
	@Transactional
	public void deleteByReplyId(Long id) {
		voteRepository.deleteByReplyId(id);
	}

	@Override
	public Vote findByReplyIdAndUserId(Long id1, Long id2) {
		return voteRepository.findByReplyIdAndUserId(id1, id2);
	}

}
