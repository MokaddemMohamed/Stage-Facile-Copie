package com.projet.annuaire.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Controller
public class MyErrorController implements ErrorController {
	/**
	 * Request method GET with requestmapping value = /error
	 * 
	 * @param model entity use in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request, Model model) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());

			if (statusCode == HttpStatus.NOT_FOUND.value())
				model.addAttribute("error", "404");
		}
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}