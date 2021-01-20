package com.projet.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projet.annuaire.service.EnterpriseService;
import com.projet.annuaire.service.StageService;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class MonitoringController {
	
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private StageService stageService;
	/**
	 * Request method GET with requestmapping value = /listEnterprises
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
    @RequestMapping(value = {"/monitoring"}, method = RequestMethod.GET)
    public String home(Model model) {
    	model.addAttribute("listStages",stageService.findAll());
    	model.addAttribute("listEnterprise",enterpriseService.findAll());
        return "monitoring";
    }
}
