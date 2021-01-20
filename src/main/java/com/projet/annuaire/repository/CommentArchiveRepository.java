package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.CommentArchive;


public interface CommentArchiveRepository extends JpaRepository<CommentArchive, Long>{

	 List <CommentArchive> findAll();
	 
}
