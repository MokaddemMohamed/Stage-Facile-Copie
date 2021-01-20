package com.projet.annuaire.data;

import java.util.List;

import com.projet.annuaire.model.Enterprise;
import com.projet.annuaire.model.Field;
import com.projet.annuaire.model.Stage;
import com.projet.annuaire.model.Tutor;
import com.projet.annuaire.model.User;
/**
 * 
 * @author LE Dan
 *
 */
public class GeneratorStage {
	private String startDate;
	private String endDate;
	private List<String> subject;
	private List<String> description;
	private int gratification;
	private List<String> trainingRequired;
	private List<String> city;
	private List<String> country;
	
	private Enterprise enterprise;
	private User user;
	private Tutor tutor;
	private Field field;
	
	
	public GeneratorStage(){
		
	}
	
	public Stage loadStage(String id,String validated,String startDate, String endDate, String subject, String description, float gratification, String trainingRequired, String country, Enterprise enterprise, User user, Tutor tutor, Field field, String administrator) {
		Stage s = new Stage();
		s.setEnterprise(enterprise);
		s.setUser(user);
		s.setCompanyName(s.getEnterprise().getName());
		s.setValidated(validated);
		s.setStartDate(startDate);
		s.setEndDate(endDate);
		s.setSubject(subject);
		s.setDescription(description);
		s.setGratification(gratification);
		s.setTutor(tutor);
		s.setCity(s.getEnterprise().getTown());
		s.setCountry(country);
		s.setField(field);
		s.setTrainingRequired(trainingRequired);
		s.setAdministrator(administrator);
		s.setId(Long.parseLong(id));
		return s;
	}
}
