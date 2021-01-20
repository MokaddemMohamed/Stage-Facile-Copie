package com.projet.annuaire.model;

import javax.persistence.*;
/**
 * 
 * @author MOKADDEM Mohamed
 *
 */
@Entity
@Table(name = "tutor")
public class Tutor {
	private Long id;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String mail;
	
	public Tutor() {
	    super();
	  }

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	  
	  /*	private Long id;
	private String lastName;
	private String firstName;
	private String phoneNumber;
	private String mail;*/
	
	public void string() {
		System.out.println(lastName + firstName + phoneNumber + mail);
	}

}
