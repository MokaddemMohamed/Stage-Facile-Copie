package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.Role;
import com.projet.annuaire.model.RoleArchive;

public interface RoleArchiveRepository extends JpaRepository<RoleArchive, Long>{

	List <RoleArchive> findAll();
}
