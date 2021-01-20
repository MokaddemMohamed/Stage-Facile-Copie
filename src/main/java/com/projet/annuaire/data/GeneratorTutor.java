package com.projet.annuaire.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.projet.annuaire.model.Tutor;
/**
 * 
 * @author LE Dan
 *
 */
public class GeneratorTutor {
	private List <String> lastName;
	private List <String> firstName;

	private String mail;
	public GeneratorTutor() {
		
	}
	public GeneratorTutor(String pathLastName, String pathFirstName) throws IOException {
		this.lastName = new ArrayList<String>();
		this.firstName = new ArrayList<String>();

		readFile(this.lastName,pathLastName);
		readFile(this.firstName,pathFirstName);


	}
	/**
	 * Read a file
	 * @param file entity file
	 * @param path entity path
	 * @return list of words
	 * @throws IOException
	 */
	public String [] readFile(List<String> file, String path) throws IOException {
		BufferedReader IN = new BufferedReader (new FileReader(path));
		String ligne;
		String [] mot = null;
		while ((ligne = IN.readLine ())!= null) {
		     mot = ligne.split (" ");
		     file.add(ligne);
		}
		return mot;

	}
	/**
	 * Generate a random tutor
	 * @return random tutor
	 */
	public Tutor generateTutor() {
	Tutor t = new Tutor();
	Random r = new Random();
	
	int randomLastName = 0 + r.nextInt(this.lastName.size() - 0);
	int randomFirstName = 0 + r.nextInt(this.firstName.size() - 0);

	String mail = firstName.get(randomFirstName) + "@"+lastName.get(randomLastName)+".com";
	
	t.setLastName(lastName.get(randomLastName));
	t.setFirstName(firstName.get(randomFirstName));
	t.setPhoneNumber(generateNumber());
	t.setMail(mail);
	return t;
	}
	/**
	 * Generate a number
	 * @return number	
	 */
	public String generateNumber() {
	Random r = new Random();
	long randomNumber;
	String tmp = "";
	for(int i = 0; i<10;i++) {
		randomNumber = r.nextInt(10);
		tmp = tmp+randomNumber;
	}
		
	return tmp;
	}
	/**
	 * create a specific tutor
	 * @param firstName tutor firstName
	 * @param lastName tutor lastName
	 * @param mail tutor Mail
	 * @param number tutor number
	 * @return tutor create
	 */
	public Tutor loadTutor(String firstName, String lastName, String mail, String number) {
	Tutor t = new Tutor();
	t.setLastName(lastName);
	t.setFirstName(firstName);
	t.setPhoneNumber(number);
	t.setMail(mail);
	return t;
}
}
