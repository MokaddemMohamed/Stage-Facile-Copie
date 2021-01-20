package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.EnterpriseArchive;

public interface EnterpriseArchiveRepository extends JpaRepository<EnterpriseArchive, Long> {

	List <EnterpriseArchive> findAll();

}
