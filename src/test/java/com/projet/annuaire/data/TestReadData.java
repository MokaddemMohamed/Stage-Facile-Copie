package com.projet.annuaire.data;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.TutorArchive;
import com.projet.annuaire.model.User;
import com.projet.annuaire.model.UserArchive;
import com.projet.annuaire.repository.EnterpriseRepository;
import com.projet.annuaire.repository.FieldRepository;
import com.projet.annuaire.repository.StageRepository;
import com.projet.annuaire.repository.TutorRepository;
import com.projet.annuaire.repository.TutorArchiveRepository;
import com.projet.annuaire.repository.UserArchiveRepository;
import com.projet.annuaire.service.ImportService;
import com.projet.annuaire.service.UserService;


@SpringBootTest
class TestReadData {
	
	User user;
	
	private ReadData readData;
	
	@Autowired
	private FieldRepository fieldRepository;
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	@Autowired
	private TutorRepository tutorRepository;

	@Autowired
	private StageRepository stageRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImportService importService;
	
	@Autowired
	private TutorArchiveRepository tutorsRepository;
	
	@Autowired
	private UserArchiveRepository usersRepository;
	
	List <Stage> listStage ;
	List <Tutor> listTutor;
	List <Enterprise> listEnterprise;
	
	List <TutorArchive> listTutors;
	
	List <UserArchive> listUsers;

	@BeforeEach
	void setUp() throws Exception {
		listTutor = tutorRepository.findAll();
	}
	/*@Ignore
	@Test
	void testLoadData() throws IOException {
		
		readData = new ReadData(tutorRepository,userService,enterpriseRepository,fieldRepository,stageRepository);
		readData.loadData("src/main/resources/test.txt", "Informatique");
	}*/
	
	@Test
	public void testSaveTuteur() {
		
		System.out.println("111111111111111111111111111111111111111111111111");
		importService.saveTuteur();
		listTutors = tutorsRepository.findAll();
		for(TutorArchive tutors : listTutors ) {
			System.out.println("+++++++++++++++++++++++++"+tutors.getFirstName());
		}
	}
	
	/*
	@Ignore
	@Test
	public void testSaveModel() {
		listTutor = tutorRepository.findAll();
		listEnterprise = enterpriseRepository.findAll();
		listStage = stageRepository.findAll();
		importService.saveModel(listTutor, listEnterprise,listStage);
		
		listTutors = tutorsRepository.findAll();
		for(Tutors tutors : listTutors ) {
			System.out.println("+++++++++++++++++++++++++"+tutors.getFirstName());
		}
		
		
		
		System.out.println("+++++++++++++++++++++++++");
		listUsers = usersRepository.findAll();
		System.out.println("------------------------------------------");
		for(Users users : listUsers ) {
			System.out.println("------------------------------------------");
			System.out.println("****************************"+users.getFirstName());
		}
	}*/
	
	

}
