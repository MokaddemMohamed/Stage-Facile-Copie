package com.projet.annuaire.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.model.CommentArchive;
import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.EnterpriseArchive;
import com.projet.annuaire.model.Field;
import com.projet.annuaire.model.FieldArchive;
import com.projet.annuaire.model.Role;
import com.projet.annuaire.model.RoleArchive;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.StageArchive;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.TutorArchive;
import com.projet.annuaire.model.User;
import com.projet.annuaire.model.UserArchive;
import com.projet.annuaire.repository.CommentRepository;
import com.projet.annuaire.repository.CommentArchiveRepository;
import com.projet.annuaire.repository.EnterpriseRepository;
import com.projet.annuaire.repository.EnterpriseArchiveRepository;
import com.projet.annuaire.repository.FieldRepository;
import com.projet.annuaire.repository.FieldArchiveRepository;
import com.projet.annuaire.repository.RoleRepository;
import com.projet.annuaire.repository.RoleArchiveRepository;
import com.projet.annuaire.repository.StageRepository;
import com.projet.annuaire.repository.StageArchiveRepository;
import com.projet.annuaire.repository.TutorRepository;
import com.projet.annuaire.repository.TutorArchiveRepository;
import com.projet.annuaire.repository.UserRepository;
import com.projet.annuaire.repository.UserArchiveRepository;

@Service
public class ImportServiceImpl implements ImportService{
	
	@Autowired
	private StageRepository stageRepository;
	@Autowired
	private FieldRepository fieldRepository;
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
	private StageArchiveRepository stageArchiveRepository;
    @Autowired
    private TutorArchiveRepository tutorArchiveRepository;
	@Autowired
	private UserArchiveRepository userArchiveRepository;
	@Autowired
	private FieldArchiveRepository fieldArchiveRepository;
	@Autowired
    private RoleArchiveRepository roleArchiveRepository;
	@Autowired
	private CommentArchiveRepository commentArchiveRepository;
	@Autowired
	private EnterpriseArchiveRepository enterpriseArchiveRepository;
	
	/*List <Stage> listStage ;
	List <Tutor> listTutor;
	List <Enterprise> listEnterprise;
	List <Field>listField;
	List <Role> listRole;
	List <Comment> listComment;
	List <User> listUser;*/
	
	/*List <Stage> listStages ;
	List <Tutor> listTutors;
	List <Enterprise> listEnterprises;
	List <Field>listFields;
	List <Role> listRoles;
	List <Comment> listComments;*/
	List <User> listUsers;
	List <TutorArchive> tutors;
	List<Tutor> listTutor;
	
	@Override
	public void saveTuteur() {
		listTutor = tutorRepository.findAll();
		
		for(Tutor tutor : listTutor) {
			tutorArchiveRepository.save(tutor);
		}
	}
	
	@Override
	public void saveModel(List<Tutor> listTutor, List<Enterprise> listEnterprise, List<Stage> listStage ) {
		listTutor = tutorRepository.findAll();
		listEnterprise = enterpriseRepository.findAll();
		listStage = stageRepository.findAll();
		
		for(Tutor tutor : listTutor) {
			tutorArchiveRepository.save(tutor);
		}
		/*
		for(Enterprise enterprise : listEnterprise) {
			enterpriseArchiveRepository.save(enterprise);
		}
		*/
		
		for(Stage stage : listStage) {
			stageArchiveRepository.save(stage);
		}
	}
	
	@Override
	public List<TutorArchive> findAll(){
		return tutorArchiveRepository.findAll();
	}

	@Override
	public void saveUsers(List<User> listUser) {
		
		listUsers = userRepository.findAll();
		
		for(User user : listUsers) {
			userArchiveRepository.save(user);
		}
		
	}
	
	public void generateArchives(StageService stageService, StageArchive stageArchive) {
		
		
		List <Stage> S = stageService.findAll();
		
		for ( Stage s : S ) {
			stageArchive.convertStageToArchive(s);
			stageArchiveRepository.save(stageArchive);
		}
	}

	
	
	
	/*@Override
	public void delete() {
		listUser = userRepository.findAll();
		listTutor = tutorRepository.findAll();
		listEnterprise = enterpriseRepository.findAll();
		
		for(User user : listUser) {
			userRepository.deleteById(user.getId());
		}
		for(Enterprise enterprise : listEnterprise) {
			enterpriseRepository.deleteById(enterprise.getId());
		}
		for(Tutor tutor : listTutor) {
			tutorRepository.deleteById(tutor.getId());
		}
	}*/
	
	/*@Override
	public void saveData() {
		listUser = userRepository.findAll();
		listTutor = tutorRepository.findAll();
		listEnterprise = enterpriseRepository.findAll();
		listField = fieldRepository.findAll();
		listStage = stageRepository.findAll();
		listRole = roleRepository.findAll();
		listComment = commentRepository.findAll();
		
		
		for(User user : listUser) {
			usersRepository.save(user);
		}
		
		for(Tutor tutor : listTutor) {
			tutorsRepository.save(tutor);
		}
		
		for(Enterprise enterprise : listEnterprise) {
			enterpriseRepository.save(enterprise);
		}
		
		for(Field field : listField) {
			fieldsRepository.save(field);
		}
		
		for(Stage stage : listStage) {
			stagesRepository.save(stage);
		}
		
		for(Role role : listRole) {
			rolesRepository.save(role);
		}
		
		for(Comment comment : listComment) {
			commentsRepository.save(comment);
		}
	}
	
	@Override
	public void deleteData() {
		listUsers = usersRepository.findAll();
		listTutors = tutorsRepository.findAll();
		listEnterprises = enterprisesRepository.findAll();
		listFields = fieldsRepository.findAll();
		listStages = stagesRepository.findAll();
		listRoles = rolesRepository.findAll();
		listComments = commentsRepository.findAll();
		
		for(User users : listUsers) {
			usersRepository.deleteById(users.getId());
		}
		
		for(Tutor tutors : listTutors) {
			tutorsRepository.deleteById(tutors.getId());
		}
		
		for(Enterprise enterprises : listEnterprises) {
			enterprisesRepository.deleteById(enterprises.getId());
		}
		
		for(Field fields : listFields) {
			fieldsRepository.deleteById(fields.getId());
		}
		
		for(Stage stages : listStages) {
			stagesRepository.deleteById(stages.getId());
		}
		
		for(Role roles : listRoles) {
			rolesRepository.deleteById(roles.getId());
		}
		
		for(Comment comments : listComments) {
			commentsRepository.deleteById(comments.getId());
		}
		
	}*/

}
