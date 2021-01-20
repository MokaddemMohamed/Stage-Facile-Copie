package com.projet.annuaire.service;

import java.util.List;
import java.util.Optional;

import com.projet.annuaire.model.Field;

public interface FieldService {
	/**
	 * All field
	 * @return list of all field
	 */
	List<Field> findAll();
	/**
	 * Search field by id
	 * @param id field id
	 * @return field find by id
	 */
	Field findById(Long id);
	
}
