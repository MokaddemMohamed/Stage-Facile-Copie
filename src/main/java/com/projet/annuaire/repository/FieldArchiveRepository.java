package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Field;
import com.projet.annuaire.model.FieldArchive;

public interface FieldArchiveRepository extends JpaRepository<FieldArchive, Long>{

	List <FieldArchive> findAll();
}
