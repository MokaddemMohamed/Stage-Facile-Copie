package com.projet.annuaire.model;

import java.util.Set;

//import java.util.Date;
import javax.persistence.*;
/**
 * 
 * @author FALL Latty
 * @author MOKADDEM Mohamed
 *
 */
@Entity
@Table(name = "stageArchive")
public class StageArchive {
	private Enterprise enterprise;
	private Comment comment;
	private User user;
	private Long id;
	private String companyName;
	private String validated;
	private String startDate;
	private String endDate;
	private String subject;
	private String description;
	private double gratification;
	private Tutor tutor;
	private Long idTutor;
	private String trainingRequired;
	private String city;
	private String country;
	private Field field;
	private long title;
	private String administrator;
	public StageArchive() {
		super();
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Transient
	public long getTitle() {
		return title;
	}

	public void setTitle(long title) {
		this.title = title;
	}



	public double getGratification() {
		return gratification;
	}

	public void setGratification(double gratification) {
		this.gratification = gratification;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(length = 1024)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrainingRequired() {
		return trainingRequired;
	}

	public void setTrainingRequired(String trainingRequired) {
		this.trainingRequired = trainingRequired;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToOne
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	@OneToOne(mappedBy = "stage")
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@ManyToOne
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@Transient
	public Long getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Long idTutor) {
		this.idTutor = idTutor;
	}

	@ManyToOne
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public String getAdministrator() {
		return administrator;
	}

	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	public void string() {
		System.out.println(" E name = " + enterprise.getName() + " U name" + user.getUsername() + " C name"
				+ companyName + " V " + validated + " Start " + startDate + " End " + endDate + " Sub " + subject
				+ " Desc " + description + " Grat " + gratification + " T name " + tutor.getFirstName() + " Train "
				+ trainingRequired + " City " + city + " Country " + country + " F title " + field.getTitle());
	}
	

	public int validated() {

		if(validated.contains("Validée")) {
			return 1;
		}
		if(validated.contains("cours")) {
			return 0;
		}
		return -1;

	}

	public void convertStageToArchive(Stage stage) {
		this.id = stage.getId();
		this.administrator = stage.getAdministrator();
		this.city = stage.getCity();
		this.comment = stage.getComment();
		this.companyName = stage.getCompanyName();
		this.country = stage.getCountry();
		this.description = stage.getDescription();
		this.startDate = stage.getStartDate();
		this.endDate = stage.getEndDate();
		this.enterprise = stage.getEnterprise();
		this.field = stage.getField();
		this.gratification = stage.getGratification();
		this.idTutor = stage.getIdTutor();
		this.subject = stage.getSubject();
		this.title = stage.getTitle();
		this.trainingRequired = stage.getTrainingRequired();
		this.tutor = stage.getTutor();
		this.user = stage.getUser();
		this.validated = stage.getValidated();
	}
}