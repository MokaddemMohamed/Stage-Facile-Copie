package com.projet.annuaire.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.model.Reply;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.Vote;
import com.projet.annuaire.service.CommentService;
import com.projet.annuaire.service.EnterpriseService;
import com.projet.annuaire.service.FieldService;
import com.projet.annuaire.service.ReplyService;
import com.projet.annuaire.service.SecurityService;
import com.projet.annuaire.service.StageService;
import com.projet.annuaire.service.TutorService;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.service.VoteService;
import com.projet.annuaire.validator.StageValidator;

/**
 * 
 * @author MOKADDEM Mohamed
 *
 */

@Controller
public class StageController {

	@Autowired
	private FieldService fieldService;

	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private StageService stageService;

	@Autowired
	private TutorService tutorService;

	@Autowired
	private ReplyService replyService;

	@Autowired
	private StageValidator stageValidator;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private VoteService voteService;

	/**
	 * Request method GET with requestmapping value = listStages and lists
	 * 
	 * @param model entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/listStages", "/lists" }, method = RequestMethod.GET)
	public String listStages(Model model) {
		model.addAttribute("listStages", stageService.findAll());
		return "listStages";
	}

	/**
	 * Request method GET with requestmapping value = /addStage
	 * 
	 * @param model entity usedd in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/addStage")
	public String registration(Model model) {
		model.addAttribute("stageForm", new Stage());
		model.addAttribute("listEnterprise", enterpriseService.findAll());
		model.addAttribute("listField", fieldService.findAll());
		model.addAttribute("listTutor", tutorService.findAll());

		return "addStage";
	}

	/**
	 * Request method POST with requestmapping value = /addStage
	 * 
	 * @param stageForm     construct stage with value in jsp page
	 * @param bindingResult entity for validator
	 * @return name of jsp page
	 */
	@PostMapping("/addStage")
	public String registration(@ModelAttribute("stageForm") Stage stageForm, BindingResult bindingResult) {
		stageValidator.validate(stageForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "addStage";
		}
		stageForm.setUser(userService.findByUsername(securityService.findLoggedInUser()));
		stageForm.setEnterprise(enterpriseService.findById(Long.parseLong(stageForm.getCompanyName())));
		stageForm.setCompanyName(enterpriseService.findById(Long.parseLong(stageForm.getCompanyName())).getName());
		stageForm.setValidated(null);
		stageForm.setField(fieldService.findById(stageForm.getTitle()));
		stageForm.setTutor(tutorService.findById(stageForm.getIdTutor()));
		stageForm.setValidated("");
		stageService.save(stageForm);
		return "redirect:/account/traineeships/" + stageForm.getUser().getUsername();
	}

	/**
	 * Request method GET with requestmapping value = /stage/update/{id}
	 * 
	 * @param model entity used in jsp page
	 * @param id    entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/update/{id}" }, method = RequestMethod.GET)
	public String stage(Model model, @PathVariable Long id) {
		model.addAttribute("stageForm", stageService.findById(id));
		model.addAttribute("listEnterprise", enterpriseService.findAll());
		model.addAttribute("listField", fieldService.findAll());
		model.addAttribute("listTutor", tutorService.findAll());
		return "updateStage";
	}

	/**
	 * Request method POST with requestmapping value = /stage/update/{id}
	 * 
	 * @param stageForm     construct stage with value in jsp page
	 * @param bindingResult entity for validator
	 * @param model         entity used in jsp page
	 * @param id            entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/update/{id}" }, method = RequestMethod.POST)
	public String stage(@ModelAttribute("stageForm") Stage stageForm, BindingResult bindingResult, Model model,
			@PathVariable Long id) {
		// Prevent to update a stage if you're not the author
		Stage stage = stageService.findById(id);
		if (!stage.getUser().getUsername().equals(securityService.findLoggedInUser())) {
			model.addAttribute("error", "403");
			return "redirect:/error";
		}

		model.addAttribute("stageForm", stage);
		stageForm.setUser(userService.findByUsername(securityService.findLoggedInUser()));
		// stageForm.setEnterprise(enterpriseRepository.findByName(enterpriseForm.getName()));
		stageForm.setEnterprise(enterpriseService.findByName(stageForm.getCompanyName()));
		stageForm.setCompanyName(enterpriseService.findById(Long.parseLong(stageForm.getCompanyName())).getName());
		stageForm.setField(fieldService.findById(stageForm.getTitle()));
		stageForm.setTutor(tutorService.findById(stageForm.getIdTutor()));
		if (bindingResult.hasErrors()) {
			return "/stage/update/{id}";
		}
		stageService.update(stageForm, id);

		return "redirect:/account/traineeships/" + stageForm.getUser().getUsername();
	}

	/**
	 * Request method GET with requestmapping value = /stage/updateTeacher/{id}
	 * 
	 * @param model entity used in jsp page
	 * @param id    entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/updateTeacher/{id}" }, method = RequestMethod.GET)
	public String stageT(Model model, @PathVariable Long id) {
		model.addAttribute("stageForm", stageService.findById(id));
		model.addAttribute("listEnterprise", enterpriseService.findAll());
		model.addAttribute("listField", fieldService.findAll());
		model.addAttribute("listTutor", tutorService.findAll());
		return "updateStageTeacher";
	}

	/**
	 * Request method POST with requestmapping value = /stage/updateTeacher/{id}
	 * 
	 * @param stageForm     construct stage with value in jsp page
	 * @param bindingResult entity for validator
	 * @param model         entity used in jsp page
	 * @param id            entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/updateTeacher/{id}" }, method = RequestMethod.POST)
	public String stageT(@ModelAttribute("stageForm") Stage stageForm, BindingResult bindingResult, Model model,
			@PathVariable Long id) {
		model.addAttribute("stageForm", stageService.findById(id));
		stageForm.setUser(userService.findByUsername(securityService.findLoggedInUser()));
		// stageForm.setEnterprise(enterpriseRepository.findByName(enterpriseForm.getName()));
		stageForm.setEnterprise(enterpriseService.findByName(stageForm.getCompanyName()));
		stageForm.setCompanyName(enterpriseService.findById(Long.parseLong(stageForm.getCompanyName())).getName());
		stageForm.setField(fieldService.findById(stageForm.getTitle()));
		stageForm.setTutor(tutorService.findById(stageForm.getIdTutor()));
		if (bindingResult.hasErrors()) {
			return "/stage/update/{id}";
		}
		stageService.update(stageForm, id);

		return "redirect:/account/traineeships/" + stageForm.getUser().getUsername();
	}

	/**
	 * Request method GET with requestmapping value = /stage/delete/{id}
	 * 
	 * @param model entity used in jsp page
	 * @param id    entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/delete/{id}" }, method = RequestMethod.GET)
	public String deleteStage(Model model, @PathVariable Long id) {
		// Prevent to update a stage if you're not the author
		Stage stage = stageService.findById(id);
		if (!stage.getUser().getUsername().equals(securityService.findLoggedInUser())) {
			model.addAttribute("error", "403");
			return "redirect:/error";
		}

		model.addAttribute("stageForm", stage);
		String name = stage.getUser().getUsername();
		Comment toBeDeleted = stage.getComment();
		commentService.deleteById(toBeDeleted.getId());
		// commentService.deleteById(stageRepository.findId(id).getComments());
		stageService.deleteById(id);
		return "redirect:/account/traineeships/" + name;
	}

	/**
	 * Request method GET with requestmapping value = /stage/details/{id}
	 * 
	 * @param model entity used in jsp page
	 * @param id    entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/stage/details/{id}" }, method = RequestMethod.GET)
	public String detailsStage(Model model, @PathVariable Long id) {
		Stage stage = stageService.findById(id);
		model.addAttribute("stage", stage);

		if (stage.getComment() != null) {
			Set<Reply> listReplies = replyService.findByCommentIdOrderByDateAsc(stage.getComment().getId());
			// Setting the votes for the replies
			int value = 0;
			for(Reply r : listReplies) {
				for(Vote v : r.getVotes())
					value += v.getValue();
				r.setVote(value);
				value = 0;
			}
			model.addAttribute("listReplies", listReplies);
			model.addAttribute("newReply", new Reply());
		}
		return "detailsStage";
	}
}