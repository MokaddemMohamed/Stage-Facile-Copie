package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.StageArchive;
import com.projet.annuaire.model.Tutor;

public interface StageArchiveRepository extends JpaRepository<StageArchive, Long>{

	List<StageArchive> findAll();

	void save(Stage stage);  
	

}
