package com.projet.annuaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 
 * @author LE Dan
 *
 */
@Controller
public class HomeController {
    /**
     * Request method GET with requestmapping value = /home
     * @param model entity use in jsp page
     * @return name of jsp page
     */
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
}