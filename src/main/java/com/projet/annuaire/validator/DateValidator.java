package com.projet.annuaire.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 
 * @author LE Dan
 *
 */
public class DateValidator {

	// Email Regex java
	private static final String DATE_REGEX = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

	// static Pattern object, since pattern is fixed
	private static Pattern pattern;

	// non-static Matcher object because it's created from the input String
	private Matcher matcher;

	public DateValidator() {
		// initialize the Pattern object
		pattern = Pattern.compile(DATE_REGEX, Pattern.CASE_INSENSITIVE);
	}

	/**
	 * This method validates the input email address with EMAIL_REGEX pattern
	 * 
	 * @param email
	 * @return boolean
	 */
	public boolean isValidDate(String date) {
		matcher = pattern.matcher(date);
		return matcher.matches();	
	}
}