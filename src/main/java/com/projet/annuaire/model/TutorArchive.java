package com.projet.annuaire.model;

import javax.persistence.*;
/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "tutorArchive")
public class TutorArchive {
	private Long id;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String mail;
	
	public TutorArchive() {
	    super();
	  }

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	  
	public void string() {
		System.out.println(lastName + firstName + phoneNumber + mail);
	}

	public void convertTutorToArchive(Tutor t) {
		this.id = t.getId();
		this.firstName = t.getFirstName();
		this.lastName = t.getLastName();
		this.mail = t.getMail();
		this.phoneNumber = t.getPhoneNumber();
		
	}

}
