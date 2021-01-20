package com.projet.annuaire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.repository.CommentRepository;
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	

	@Override
	public void save(Comment enterprise) {
		commentRepository.save(enterprise);
	}
	@Override
	public void deleteById(Long id) {
		commentRepository.deleteById(id);
		
	}
	@Override
	public Comment findByStageId(long id) {
		return commentRepository.findByStageId(id);
	}

}
