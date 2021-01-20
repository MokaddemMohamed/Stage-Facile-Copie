package com.projet.annuaire.service;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Reply;
import com.projet.annuaire.repository.ReplyRepository;

/**
 * @author SCHAETZEL Robin
 */
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	private ReplyRepository replyRepository;
	

	@Override
	public void save(Reply reply) {
		replyRepository.save(reply);
	}
	@Override
	@Transactional
	public void deleteById(Long id) {
		replyRepository.deleteById(id);
		
	}
	@Override
	public Set<Reply> findByCommentIdOrderByDateAsc(Long id) {
		return replyRepository.findByCommentIdOrderByDateAsc(id);
	}
	
	@Override
	public Reply findById(Long id) {
		return replyRepository.findById(id).get();
	}
}