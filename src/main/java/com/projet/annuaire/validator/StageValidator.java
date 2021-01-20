package com.projet.annuaire.validator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.projet.annuaire.model.User;
import com.projet.annuaire.service.UserService;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.service.StageService;

@Component
public class StageValidator implements Validator {
	
	EmailValidator emailValidator = new EmailValidator();
	SiteValidator siteValidator = new SiteValidator();
	
	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}
	
	@Override
	public void validate(Object o, Errors errors) {
		Stage stage = (Stage) o;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idTutor", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startDate", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "endDate", "NotEmpty");

		
		/*if(!stage.getEndDate().equals("") && !DateValidator.isValid(stage.getStartDate())) {
			errors.rejectValue("startDate", "Form.stageForm.date");	
		}*/
		/*if(!stage.getEndDate().equals("") && !DateValidator.isValid(stage.getEndDate())) {
			errors.rejectValue("endDate", "Form.stageForm.date");	
		}*/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startDate = sdf.parse(stage.getStartDate());
			Date endDate = sdf.parse(stage.getEndDate());
			
			if(startDate.compareTo(endDate) >= 0) {
					errors.rejectValue("endDate", "Form.stageForm.dateCompare");
			}
		} catch (ParseException e) {
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gratification", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");
		
		
	}

}
