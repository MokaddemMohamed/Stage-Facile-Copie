package com.projet.annuaire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.projet.annuaire.domain.Tag;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.service.TutorService;
/**
 * @author MOKADDEM Mohamed
 * @author LE Dan
 *
 */
@Controller
public class TutorController {
	
	@Autowired
	private TutorService tutorService;

	List<Tag> data = new ArrayList<Tag>();

	/**
	 * Request method GET with requestmapping value = /listTutors
	 * 
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/listTutors" }, method = RequestMethod.GET)
	public String listTutors(Model model) {
		model.addAttribute("listTutors", tutorService.findAll());
		return "listTutors";
	}
	/**
	 * Request method GET with requestmapping value = /addTutor
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/addTutor")
	public String addTutor(Model model) {
		model.addAttribute("tutorForm", new Tutor());

		return "addTutor";
	}
	/**
	 * Request method POST with requestmapping value = /addTutor
	 * @param tutorForm construct tutor with value in jsp page
	 * @param bindingResult entity for validator
	 * @return name of jsp page
	 */
	@PostMapping("/addTutor")
	public String registrationEnterprise(@ModelAttribute("tutorForm") Tutor tutorForm,
			BindingResult bindingResult) {
		// enterpriseValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "addTutor";
		}

		tutorService.save(tutorForm);

		return "redirect:/listTutors";
	}


}
