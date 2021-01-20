package com.projet.annuaire.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projet.annuaire.model.User;
import com.projet.annuaire.service.UserService;
/**
 * 
 * @author LE Dan
 *
 */
@Component
public class UserValidator implements Validator {
	@Autowired
	private UserService userService;
	EmailValidator emailValidator = new EmailValidator();
	DateValidator dateValidator = new DateValidator();
	SiteValidator siteValidator = new SiteValidator();
	PasswordValidator passwordValidator = new PasswordValidator();
	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}
	/**
	 * Validate
	 */
	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");

		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "NotEmpty");
		if(!emailValidator.isValidateEmail(user.getMail()))
			errors.rejectValue("mail", "Form.userForm.mail");
		if(!passwordValidator.validate(user.getPassword()))
			errors.rejectValue("password", "Size.userForm.password");
		// Pour l'url complete https://www.test.com
		/*if(!siteValidator.isValid(user.getSite()))
        	errors.rejectValue("site", "Size.userForm.site");*/

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthday", "NotEmpty");
		if(dateValidator.isValidDate(user.getBirthday()))
			errors.rejectValue("birthday", "Form.userForm.date");
	}
}