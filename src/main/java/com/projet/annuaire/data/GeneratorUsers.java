package com.projet.annuaire.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.projet.annuaire.model.User;
/**
 * 
 * @author LE Dan
 *
 */


public class GeneratorUsers {
	List<String> nom ;
	List<String> prenom ;
	String email ;
	List<String> website ;
	List<String> password ;
	List <String>date ;
	String test = "test";
	
	public GeneratorUsers(String pathNom, String pathPrenom, String pathWebsite, String pathPassword,String pathDate ) throws IOException {
		this.nom = new ArrayList<String>();
		this.prenom = new ArrayList<String>();
	
		this.website = new ArrayList<String>();
		this.password = new ArrayList<String>();
		this.date = new ArrayList<String>();
		readFile(this.nom,pathNom);
		readFile(this.prenom,pathPrenom);
	
		readFile(this.website,pathWebsite);
		readFile(this.password,pathPassword);
		readFile(this.date,pathDate);
	
	
	}

	public GeneratorUsers()
	{
		
	}
	/**
	 * Read a file
	 * @param file entity file
	 * @param path entity path
	 * @return list of words
	 * @throws IOException
	 */
	public String [] readFile(List<String> a, String path) throws IOException {
	BufferedReader IN = new BufferedReader (new FileReader(path));
	String ligne;
	String [] mot = null;
	while ((ligne = IN.readLine ())!= null) {
	     mot = ligne.split (" ");
	     a.add(ligne);
	}
	return mot;

	}
	
	/**
	 * create a random user
	 * @return user random
	 * @throws ParseException
	 */
	public User generateUser() throws ParseException {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	User p = new User();
	Random r = new Random();
	String tmp;
	int randomNom = 0 + r.nextInt(this.nom.size() - 0);
	int randomPrenom = 0 + r.nextInt(this.prenom.size() - 0);

	int randomWebsite = 0 + r.nextInt(this.website.size() - 0);
	int randomPassword = 0 + r.nextInt(this.password.size() - 0);
	int randomDate = 0 + r.nextInt(this.date.size() - 0);
	
	tmp = prenom.get(randomPrenom) + "@"+nom.get(randomNom)+".com";
	p.setBirthday(generateDate());
	p.setFirstName(prenom.get(randomPrenom));
	p.setLastName(nom.get(randomNom));
	p.setMail(tmp);
	//p.setPassword(password.get(randomPassword));
	p.setPassword("1234567890");
	p.setRole("User");
	p.setTel(generateNumber());
	p.setUsername(tmp);
	return p;
	
	}
	
	/**
	 * generate a random number
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
	 * Generate a random date
	 * @return random date
	 */
	public String generateDate() {
	Random r = new Random();
	long randomNumber;
	String tmp ="19";
	randomNumber = 5 + r.nextInt(5);
	tmp = tmp+randomNumber;
	randomNumber = r.nextInt(10);
	tmp = tmp+randomNumber+"-";
	randomNumber = r.nextInt(1);
	tmp = tmp+randomNumber;
	if(randomNumber == 0) {
		randomNumber = 1+ r.nextInt(9);
		tmp = tmp+randomNumber+"-";
	}
	else {
		randomNumber = r.nextInt(3);
		tmp = tmp+randomNumber+"-";
	}
	randomNumber = r.nextInt(4);
	tmp = tmp+randomNumber;
	randomNumber = r.nextInt(10);
	tmp = tmp+randomNumber;
	
	return tmp;
	}
	/**
	 * create user with parameters
	 * @param firstName user firstName
	 * @param lastName User LastName
	 * @param number user Number
	 * @return user create
	 */
	public User loadUser(String firstName, String lastName, String number) {
	User p = new User();
	String tmp;
	tmp = firstName + "."+lastName+"@etu.univ-amu.fr";
	p.setBirthday(null);
	p.setFirstName(firstName);
	p.setLastName(lastName);
	p.setMail(tmp);
	
	p.setPassword("1234567890");
	p.setRole("User");
	
	p.setTel(number);
	p.setUsername(tmp);
	return p;
}
}