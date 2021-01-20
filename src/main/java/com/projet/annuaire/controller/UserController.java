package com.projet.annuaire.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

import com.projet.annuaire.model.PasswordResetToken;
import com.projet.annuaire.model.User;
import com.projet.annuaire.repository.RoleRepository;
import com.projet.annuaire.repository.UserRepository;
import com.projet.annuaire.service.EmailSenderService;
import com.projet.annuaire.service.PasswordResetTokenService;
import com.projet.annuaire.service.SecurityService;
import com.projet.annuaire.service.StageService;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.validator.EmailValidator;
import com.projet.annuaire.validator.UserValidator;

/**
 * 
 * @author LE Dan
 * @author SCHAETZEL Robin
 *
 */
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;
	@Autowired
	private StageService stageService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private PasswordResetTokenService passwordResetTokenService;

	@Autowired
	private EmailSenderService emailSenderService;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private RoleRepository roleRepository;

	/**
	 * Request method GET with requestmapping value = /registration
	 * 
	 * @param model entity used in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	/**
	 * Request method POST with requestmapping value = /registration
	 * 
	 * @param userForm      construct user with value in jsp page
	 * @param bindingResult entity for validator
	 * @return name of jsp page
	 */
	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		userForm.setRole("User");
		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/home";
	}

	/**
	 * Request method GET with requestmapping value = /login
	 * 
	 * @param model  entity used in jsp page
	 * @param error  entity used in jsp page
	 * @param logout entity used in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	/**
	 * Request method GET with requestmapping value = /forgotPassword
	 * 
	 * @param model entity used in jsp page
	 * @return name of jsp page
	 */
	@GetMapping("/forgotPassword")
	public String displayForgotPassword(Model model) {
		model.addAttribute("mailForm", new User());
		return "forgotPassword";
	}

	/**
	 * Request method POST with requestmapping value = /forgotPassword Sends an
	 * email with link to reset password token to user
	 * 
	 * @param mailForm construct user in jsp page
	 * @param model    entity used in jsp page
	 * @return name of jsp page
	 */
	@PostMapping("/forgotPassword")
	public String forgotUserPassword(@ModelAttribute("mailForm") User mailForm, Model model) {
		EmailValidator ev = new EmailValidator();
		if (!ev.isValidateEmail(mailForm.getMail())) {
			model.addAttribute("error", "Mail invalide");
			return "forgotPassword";
		}
		User existingUser = userService.findByMail(mailForm.getMail());
		if (existingUser == null) {
			model.addAttribute("error", "Utilisateur introuvable");
			return "forgotPassword";
		}

		PasswordResetToken token = new PasswordResetToken(existingUser);
		passwordResetTokenService.save(token);

		// Creating and send the email
		emailSenderService.prepareAndSendEmail(existingUser.getMail(), "Stage Facile : Complete Password Reset!",
				"To complete the password reset process, please click here: "
						+ "http://localhost:8080/confirmReset?token=" + token.getConfirmationToken());


		model.addAttribute("message", "Un mail de confirmation vient d'être envoyé, vérifiez votre boîte mail.");
		return "successForgotPassword";
	}

	/**
	 * Request method GET with requestmapping value = /confirmReset
	 * 
	 * @param model             entity used in jsp page
	 * @param confirmationToken requestParam in link corresponding to the token id
	 * @return name of jsp page
	 */
	@GetMapping(value = "/confirmReset")
	public String validateResetToken(Model model, @RequestParam("token") String confirmationToken) {
		PasswordResetToken token = passwordResetTokenService.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userService.findByMail(token.getUser().getMail());
			user.setPassword("");
			model.addAttribute("newPasswordUser", user);
			model.addAttribute("mail", user.getMail());
		} else {
			model.addAttribute("message", "Le lien est invalide ou cassé !");
			return "error";
		}
		return "resetPassword";
	}

	/**
	 * Request method POST with requestmapping value = /confirmReset Change user
	 * password with the form
	 * 
	 * @param newPasswordUser construct user in jsp page
	 * @param model           entity used in jsp page
	 * @return name of jsp page
	 */
	@PostMapping(value = "/confirmReset")
	public String resetUserPassword(@ModelAttribute("newPasswordUser") User user, Model model) {
		if (user.getMail() != null) {

			// Simple validators
			if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
				model.addAttribute("error", "Mot de passe invalide, essayez avec au moins 8 caractères");
				return "resetPassword";
			}
			if (!user.getPasswordConfirm().equals(user.getPassword())) {
				model.addAttribute("error", "Les mots de passe ne sont pas identiques");
				return "resetPassword";
			}

			// Use email to find user
			User tokenUser = userService.findByMail(user.getMail());
			tokenUser.setPassword(user.getPassword());
			userService.save(tokenUser);
			model.addAttribute("message",
					"Mot de passe modifié avec succès. Vous pouvez vous connecter avec vos nouveaux identifiants.");
		} else {
			model.addAttribute("message", "Le lien est invalide ou cassé !");
			return "error";
		}
		return "successResetPassword";
	}

	/**
	 * Request method GET with requestmapping value = /listUsers
	 * 
	 * @param model entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/listUsers" }, method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("listUsers", userService.findAll());
		return "listUsers";
	}

	/**
	 * Request method GET with requestmapping value = /logout
	 * 
	 * @param request  entity used in jsp page
	 * @param response entity used in jsp page
	 * @return name of jsp page
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/home?logout";// You can redirect wherever you want, but generally it's a good practice to
										// show login screen again.
	}

	/**
	 * Request method GET with requestmapping value = /account/{name}
	 * 
	 * @param model entity used in jsp page
	 * @param name  entity used for search account
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/account/{name}" }, method = RequestMethod.GET)
	public String account(Model model, @PathVariable String name) {
		model.addAttribute("userForm", userService.findByUsername(name));
		return "update";
	}

	/**
	 * Request method POST with requestmapping value = account/{name}
	 * 
	 * @param userForm      construct user with value in jsp page
	 * @param bindingResult binding result
	 * @param model         entity use in jsp page
	 * @param name          name
	 * @return name of jsp page
	 */
	@RequestMapping(value = { "/account/{name}" }, method = RequestMethod.POST)
	public String account(@ModelAttribute("userForm") User userForm, Model model, @PathVariable String name) {
		/* Faire une validation */
		model.addAttribute("userForm", userService.findByUsername(name));

		userForm.setId(userService.findByUsername(name).getId());
		userForm.setPassword(userService.findByUsername(name).getPassword());
		userForm.setPasswordConfirm(userService.findByUsername(name).getPassword());
		userForm.setRole(userService.findByUsername(name).getRole());
		userService.update(userForm, name);

		userForm.setId(userRepository.findByUsername(name).getId());
		userForm.setPassword(userRepository.findByUsername(name).getPassword());
		userForm.setPasswordConfirm(userRepository.findByUsername(name).getPassword());
		userForm.setRole(userRepository.findByUsername(name).getRole());
		userService.update(userForm, name);

		return "redirect:/home";
	}

	/**
	 * Request method GET with requestmapping value = /account/traineeships/{name}
	 * 
	 * @param model entity used in jsp page
	 * @param name  entity used in jsp page
	 * @return of jsp page
	 */
	@RequestMapping(value = { "/account/traineeships/{name}" }, method = RequestMethod.GET)
	public String traineeships(Model model, @PathVariable String name) {
		User user = new User();
		user = userService.findByUsername(name);
		if (user.Teacher()) {
			model.addAttribute("listStages",
					stageService.findByAdministrator(user.getLastName() + " " + user.getFirstName()));
			return "myTraineeshipsTeacher";
		} else {
			model.addAttribute("listStages", stageService.findByUserId(user.getId()));
			return "myTraineeships";
		}
	}

}