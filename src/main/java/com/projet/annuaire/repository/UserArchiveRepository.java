package com.projet.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.annuaire.model.User;
import com.projet.annuaire.model.UserArchive;


public interface UserArchiveRepository extends JpaRepository<UserArchive, Long> {
	 
	 List <UserArchive> findAll();

	void save(User user);
}
