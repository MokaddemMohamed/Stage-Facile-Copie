package com.projet.annuaire.service;

import java.util.List;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.StageArchive;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.TutorArchive;
import com.projet.annuaire.model.User;

public interface ImportService {
	
	void saveModel(List<Tutor> listTutor, List<Enterprise> listEnterprise, List<Stage> listStage );
	
	void saveUsers(List<User> listUser);

	List<TutorArchive> findAll();

	void saveTuteur();
	
	void generateArchives(StageService stageService,StageArchive stageArchive);

	
	/*void delete();

	void deleteData();

	void saveData();*/

}
