package com.projet.annuaire.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.projet.annuaire.model.Field;
/**
 * 
 * @author LE Dan
 *
 */
public class GeneratorFields {
	List <String> title;
	int i;
	
	
	public GeneratorFields(){
		
	}
	public List<String> getTitle() {
		return title;
	}
	public void setTitle(List<String> title) {
		this.title = title;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public GeneratorFields(String pathField) throws IOException {
		this.title = new ArrayList<String>();;
		readFile(this.title,pathField);
		i = 0;
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
	 * Load field
	 * @return field
	 */
	public Field generateField() {
		Field f = new Field();
		f.setTitle(title.get(i));
		this.i = this.i+1;
		return f;
	}
	/**
	 * Load a specific field
	 * @param title name of field
	 * @return field
	 */
	public Field loadField(String title) {
		Field f = new Field();
		f.setTitle(title);
		return f;
	}
}
