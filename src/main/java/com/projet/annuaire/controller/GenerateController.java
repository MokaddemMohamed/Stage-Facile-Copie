package com.projet.annuaire.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.data.GeneratorEnterprises;
import com.projet.annuaire.data.GeneratorFields;
import com.projet.annuaire.data.GeneratorTutor;
import com.projet.annuaire.data.GeneratorUsers;
import com.projet.annuaire.data.ReadData;
import com.projet.annuaire.model.Role;
import com.projet.annuaire.repository.EnterpriseRepository;
import com.projet.annuaire.repository.FieldRepository;
import com.projet.annuaire.repository.RoleRepository;
import com.projet.annuaire.repository.StageRepository;
import com.projet.annuaire.repository.TutorRepository;
import com.projet.annuaire.repository.UserRepository;
import com.projet.annuaire.service.SecurityService;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.validator.UserValidator;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class GenerateController {
	
	@Autowired
	private FieldRepository fieldRepository;
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	@Autowired
	private TutorRepository tutorRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private StageRepository stageRepository;
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;
	
    @Autowired
    private RoleRepository roleRepository;
    
    @RequestMapping(value = {"/generateUsers/{number}",}, method = RequestMethod.GET)
    public String generateUsers(Model model, @PathVariable int number) throws IOException, ParseException {
		GeneratorUsers u = new GeneratorUsers("src/main/resources/Nom.txt","src/main/resources/Prenom.txt","src/main/resources/Website.txt","src/main/resources/Password.txt","src/main/resources/Date.txt");
		for(int i =0;i<number;i++) {
			userService.save(u.generateUser());
		}
        return "redirect:/home";
    }
    
    @RequestMapping(value = {"/generateFields",}, method = RequestMethod.GET)
    public String generateFields(Model model) throws IOException, ParseException {
		GeneratorFields f = new GeneratorFields("src/main/resources/Domaine.txt");
		for(int i =0;i<f.getTitle().size();i++) {
			fieldRepository.save(f.generateField());
		}
        return "redirect:/home";
    }
    @RequestMapping(value = {"/generateEnterprises/{number}",}, method = RequestMethod.GET)
    public String generateEnterprises(Model model,@PathVariable int number) throws IOException, ParseException {
    	GeneratorEnterprises e = new GeneratorEnterprises("src/main/resources/EnterpriseName.txt","src/main/resources/Adress.txt","src/main/resources/Postal.txt","src/main/resources/Town.txt");
		for(int i =0;i<number;i++) {
			enterpriseRepository.save(e.generateEnterprise());
		}
        return "redirect:/home";
    }
    
    @RequestMapping(value = {"/generateStages/{number}",}, method = RequestMethod.GET)
    public String generateStages(Model model,@PathVariable int number) throws IOException, ParseException {
    	//todo
        return "redirect:/home";
    }
    @RequestMapping(value = {"/generateTutors/{number}",}, method = RequestMethod.GET)
    public String generateTutors(Model model,@PathVariable int number) throws IOException, ParseException {
    	GeneratorTutor t = new GeneratorTutor("src/main/resources/Nom.txt","src/main/resources/Prenom.txt");
    	for(int i =0;i<number;i++) {
			tutorRepository.save(t.generateTutor());
		}
        return "redirect:/home";
    }
    
    @RequestMapping(value = {"/import"}, method = RequestMethod.GET)
    public String importData(Model model) throws IOException {
    	Role Teacher = new Role();
    	Role User = new Role();
    	User.setName("User");
    	Teacher.setName("Teacher");
    	roleRepository.save(User);
    	roleRepository.save(Teacher);
    	ReadData r = new ReadData(tutorRepository, userService,enterpriseRepository,fieldRepository,stageRepository);
    	r.loadData("src/main/resources/test.txt", "Informatique");
        return "redirect:/home";
    }
    
    @RequestMapping(value = {"/importData"}, method = RequestMethod.GET)
    public String importFinal(Model model) throws IOException, ParseException {
    	generateFields(model);
    	importData(model);
    	return "redirect:/home";
    }
}
