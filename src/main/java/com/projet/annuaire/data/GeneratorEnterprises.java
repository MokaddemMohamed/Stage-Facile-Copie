package com.projet.annuaire.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.projet.annuaire.model.Enterprise;

/**
 * 
 * @author LE Dan
 */
public class GeneratorEnterprises {
	List <String> name;
	List <String> adress;
	List <String> postal;
	List <String> town;
	public GeneratorEnterprises() {
		
	}
	
	public GeneratorEnterprises(String pathName,String pathAdress,String pathPostal,String pathTown) throws IOException {
		this.name = new ArrayList<String>();
		this.adress = new ArrayList<String>();
		this.postal = new ArrayList<String>();
		this.town= new ArrayList<String>();
		readFile(this.name,pathName);
		readFile(this.adress,pathAdress);
		readFile(this.postal,pathPostal);
		readFile(this.town,pathTown);

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
	 * Generate Enterprise
	 * @return Random enterprise
	 */
	public Enterprise generateEnterprise() {
		Enterprise e = new Enterprise();
		Random r = new Random();
		int randomName = 0 + r.nextInt(this.name.size() - 0);
		int randomAdress = 0 + r.nextInt(this.adress.size() - 0);
		int randomPostal = 0 + r.nextInt(this.postal.size() - 0);
		int randomTown = 0 + r.nextInt(this.town.size() - 0);
		
		e.setName(name.get(randomName));
		e.setAdress(adress.get(randomAdress));
		e.setPostalCode(postal.get(randomPostal));
		e.setTown(town.get(randomTown));
		e.setActivity(null);
		
		return e;
	}
	/**
	 * create enterprise with all parameters
	 * @param name enterprise name
	 * @param adress enterprise adress
	 * @param postal enterprise postal
	 * @param town enterprise town
	 * @param activity enterprise activity
	 * @return enterprise create
	 */
	public Enterprise loadEnterprise(String name, String adress, String postal, String town, String activity) {
		Enterprise e = new Enterprise();
		e.setName(name);
		e.setAdress(adress);
		e.setPostalCode(postal);
		e.setTown(town);
		e.setActivity(activity);
		return e;
	}
}
