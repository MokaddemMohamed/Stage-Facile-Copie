package com.projet.annuaire.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "field")
public class Field {
	private Long id;
	private String title;
	private Set<Stage> stages;
	
	@OneToMany(mappedBy="field")
	public Set<Stage> getStages() {
		return stages;
	}
	public void setStages(Set<Stage> stages) {
		this.stages = stages;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void string() {
		System.out.println(title);
	}
}
