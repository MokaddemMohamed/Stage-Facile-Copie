package com.projet.annuaire.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Field;
import com.projet.annuaire.repository.FieldRepository;

@Service
public class FieldServiceImpl implements FieldService{
	 @Autowired
	 private FieldRepository fieldRepository;
	@Override
	public List<Field> findAll() {
		return fieldRepository.findAll();
	}
	@Override
	public Field findById(Long id) {
		return fieldRepository.findById(id).get();
	}

}
