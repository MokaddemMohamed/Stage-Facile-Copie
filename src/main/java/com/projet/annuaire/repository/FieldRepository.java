package com.projet.annuaire.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projet.annuaire.model.Field;
/**
 * 
 * @author LE Dan
 *
 */


public interface FieldRepository extends JpaRepository<Field, Long>{
	/**
	 * Search and return all field
	 */
	List<Field> findAll();

	/*
	 * Search and find field by id
	 */
	Optional<Field> findById(Long id);
	/**
	 * Search and find by title
	 * @param string title name
	 * @return field find
	 */
	Field findByTitle(String string);
}