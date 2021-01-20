package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.TutorArchive;

public interface TutorArchiveRepository extends JpaRepository<TutorArchive, Long>{
	
	List <TutorArchive> findAll();

	void save(Tutor tutor);

}
