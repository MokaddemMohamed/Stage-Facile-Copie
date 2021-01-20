package com.projet.annuaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.EnterpriseArchive;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.StageArchive;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.TutorArchive;
import com.projet.annuaire.model.User;
import com.projet.annuaire.model.Vote;
import com.projet.annuaire.repository.CommentRepository;
import com.projet.annuaire.repository.EnterpriseArchiveRepository;
import com.projet.annuaire.repository.EnterpriseRepository;
import com.projet.annuaire.repository.ReplyRepository;
import com.projet.annuaire.repository.StageArchiveRepository;
import com.projet.annuaire.repository.StageRepository;
import com.projet.annuaire.repository.TutorArchiveRepository;
import com.projet.annuaire.repository.TutorRepository;
import com.projet.annuaire.repository.VoteRepository;
import com.projet.annuaire.service.ImportService;
import com.projet.annuaire.service.SecurityService;
import com.projet.annuaire.service.StageService;
import com.projet.annuaire.service.TutorService;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.service.EnterpriseService;


/**
 * 
 * @author LATTY Fall
 * @author MOKADDEM Mohamed
 *
 */

@Controller
public class ImportController {
	
	@Autowired
	private ImportService importService;
	
	@Autowired
	private EnterpriseService enterpriseService;
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	private StageService stageService;
	
	@Autowired
	private EnterpriseArchiveRepository enterpriseArchiveRepository;
	
	@Autowired
	private StageArchiveRepository stageArchiveRepository;
	
	@Autowired
	private TutorArchiveRepository tutorArchiveRepository;
	
	@Autowired
	private EnterpriseRepository enterpriseRepository;
	
	@Autowired
	private TutorRepository tutorRepository;
	
	@Autowired
	private StageRepository stageRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ReplyRepository replyRepository;
	
	@Autowired
	private VoteRepository voteRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	

	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String deleteData(Model model) {
		//importService.save();
        return "redirect:/home";
    }
	
	
	/**
	 * Request method GET with requestmapping value = /listArchives
	 * 
	 * @param model entity usedd in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/listArchives" }, method = RequestMethod.GET)
	public String listArchives(Model model) {
	
		model.addAttribute("listStagesArchive", stageArchiveRepository.findAll());
		User user = new User();
		user = userService.findByUsername(securityService.findLoggedInUser());
		if (user.Teacher()) {
			return "listArchivesTeacher";
		}
		else {
		return "listArchives";
		}
	}
	
	
	/**
	 * Request method GET with requestmapping value = /archiveStages
	 * 
	 * @param model entity usedd in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/archiveStages" }, method = RequestMethod.GET)
	public String archiveStages(Model model) {
		
		StageArchive stageArchive = new StageArchive();
		importService.generateArchives(stageService, stageArchive);

		model.addAttribute("listStagesArchive", stageArchiveRepository.findAll());
		
		voteRepository.deleteAll();
		replyRepository.deleteAll();
		commentRepository.deleteAll();
		stageRepository.deleteAll();

		return "listArchives";
	}
	
}
