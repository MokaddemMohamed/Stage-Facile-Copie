package com.projet.annuaire.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.projet.annuaire.domain.Tag;
import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.service.EnterpriseService;
import com.projet.annuaire.service.StageService;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class EnterpriseController {


	@Autowired
	private EnterpriseService enterpriseService;

	@Autowired
	private StageService stageService;
	
	List<Tag> data = new ArrayList<Tag>();
	boolean load;
	
	EnterpriseController(){
		load = true;
	}

	/**
	 * Request method GET with requestmapping value = /listEnterprises
	 * 
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/listEnterprises" }, method = RequestMethod.GET)
	public String listEnterprises(Model model) {
		model.addAttribute("listEnterprises", enterpriseService.findAll());
		return "listEnterprises";
	}
	/**
	 * Request method GET with requestmapping value = /registrationEnterprise
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/registrationEnterprise")
	public String registrationEnterprise(Model model) {
		model.addAttribute("enterpriseForm", new Enterprise());

		return "registrationEnterprise";
	}
	/**
	 * Request method POST with requestmapping value = /registrationEnterprise
	 * @param enterpriseForm construct enterprise with value in jsp page
	 * @param bindingResult entity for validator
	 * @return name of jsp page
	 */
	@PostMapping("/registrationEnterprise")
	public String registrationEnterprise(@ModelAttribute("enterpriseForm") Enterprise enterpriseForm,
			BindingResult bindingResult) {
		// enterpriseValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registrationEnterprise";
		}

		enterpriseService.save(enterpriseForm);

		return "redirect:/listEnterprises";
	}
	/**
	 * Request method GET with requestmapping value = /enterprise/update/{id}
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/enterprise/update/{id}" }, method = RequestMethod.GET)
	public String enterprise(Model model, @PathVariable Long id) {
		model.addAttribute("enterpriseForm", enterpriseService.findById(id));
		return "updateEnterprise";
	}
	/**
	 * Request method POST with requestmapping value = /enterprise/update/{id}
	 * @param enterpriseForm construct enterprise with value in jsp page
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */ 
	
	@RequestMapping(value = { "/enterprise/update/{id}" }, method = RequestMethod.POST)
	public String enterprise(@ModelAttribute("enterpriseForm") Enterprise enterpriseForm, Model model,
			@PathVariable Long id) {
		/* attention la validation marche pas */
		model.addAttribute("enterpriseForm", enterpriseService.findById(id));

		enterpriseService.update(enterpriseForm, id);
		return "redirect:/listEnterprises";
	}
	/**
	 * Request method GET with requestmapping value = /enterprise/delete/{id}
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/enterprise/delete/{id}" }, method = RequestMethod.GET)
	public String deleteEnterprise(Model model, @PathVariable Long id) {
		model.addAttribute("enterpriseForm", enterpriseService.findById(id));
		//ajouter la suppression en cascade ( peux être )
		enterpriseService.delete(id);
		return "redirect:/listEnterprises";
	}
	/**
	 * Request method POST with requestmapping value = /enterprise/search
	 * @param model entity use in jsp page
	 * @param search entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/enterprise/search" }, method = RequestMethod.POST)
	public String search(Model model, @RequestParam("search-value") String search) {
		model.addAttribute("listEnterprises", enterpriseService.findAllByFirstName(search));
		return "/listEnterprises";
	}
	/**
	 * Request method GET with requestmapping value = /enterprise/search
	 * @param model entity use in jsp page
	 * @param id entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/enterprise/{id}/ListStages" }, method = RequestMethod.GET)
	public String searchEnterprisePerStage(Model model, @PathVariable Long id ){
		model.addAttribute("listStages", stageService.findByEnterpriseId(id));
		return "listStages";
	}
	/**
	 * Request method GET with requestmapping value = /
	 * @return model
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {
		if(load) {
			RemplirTag();
			load=false;
		}
		ModelAndView model = new ModelAndView("home");
		return model;
	}
	/**
	 * Request method GET with requestmapping value = /getTags
	 * @param tagName entity use in jsp page
	 * @return List of simulate search
	 */
	@RequestMapping(value = "/getTags", method = RequestMethod.GET)
	public @ResponseBody
	List<Tag> getTags(@RequestParam String tagName) {

		return simulateSearchResult(tagName);
	}
	/**
	 * Function add enterprise name to list data 
	 */
    private void RemplirTag() {
		// init data for testing
		List <Enterprise> tmp = new ArrayList<Enterprise>();
		tmp = enterpriseService.findAll();
		int i = 0;
		for(Enterprise e : tmp) {
			this.data.add(new Tag(i,e.getName().toLowerCase()));
			i++;
		}
    }
    /**
     * Function simulate search
     * @param tagName filter
     * @return simulate search
     */
	private List<Tag> simulateSearchResult(String tagName) {

		List<Tag> result = new ArrayList<Tag>();

		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;
	}
}
