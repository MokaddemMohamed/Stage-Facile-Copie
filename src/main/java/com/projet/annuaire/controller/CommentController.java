package com.projet.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.model.Comment;
import com.projet.annuaire.service.CommentService;
import com.projet.annuaire.service.StageService;
/**
 * 
 * @author LE Dan
 *
 */

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	
	@Autowired
	private StageService stageService;

	/**
	 * Request method GET with requestmapping value = /comment/add/{id}
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/comment/add/{id}" }, method = RequestMethod.GET)
	public String comment(Model model, @PathVariable Long id) {
		model.addAttribute("commentForm", new Comment());
		return "comment";
	}
	
	/**
	 * Request method POST with requestmapping value = /comment/add/{id}
	 * @param commentForm construct comment with value in jsp page
	 * @param id entity use in jsp page
	 * @param bindingResult entity for validator
	 * @return name of jsp page
	 */
	@PostMapping("/comment/add/{id}")
	public String comment(@ModelAttribute("commentForm") Comment commentForm, @PathVariable Long id,
			BindingResult bindingResult) {
		//Validator a faire
		// enterpriseValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registrationEnterprise";
		}

		if(commentService.findByStageId(id) == null) {
		commentForm.setStage(stageService.findById(id));
		commentService.save(commentForm);
		}
		else {
			commentForm.setId(commentService.findByStageId(id).getId());
			commentForm.setStage(stageService.findById(id));
			commentService.save(commentForm);
		}
		
		String name = commentForm.getStage().getUser().getUsername();
		return "redirect:/account/traineeships/"+name;
	}
	
	/**
	 * Request method GET with requestmapping value = /comment/update/{id}
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/comment/update/{id}" }, method = RequestMethod.GET)
	public String updateComment(Model model, @PathVariable Long id) {
		model.addAttribute("commentForm",commentService.findByStageId(id));
		return "comment";
	}
	/**
	 * Request method POST with requestmapping value = /comment/update/{id}
	 * @param commentForm construct comment with value in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/comment/update/{id}" }, method = RequestMethod.POST)
	public String updateComment(@ModelAttribute ("commentForm") Comment commentForm, @PathVariable Long id) {
		commentForm.setId(commentService.findByStageId(id).getId());
		commentForm.setStage(stageService.findById(id));
		
		commentService.save(commentForm);
		return "redirect:/listStages";
	}
	/**
	 * Request method GET with requestmapping value = /comment/show/{id}
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/comment/show/{id}" }, method = RequestMethod.GET)
	public String showComment(Model model, @PathVariable Long id) {
		model.addAttribute("comment",commentService.findByStageId(id));
		return "showComment";
	}
}