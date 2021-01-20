package com.projet.annuaire.model;

import java.util.Set;

import javax.persistence.*;

/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "enterprise")
public class Enterprise {
    private Long id;
    private String name;
    private String adress;
    private String postalCode;
    private String town;
    private String activity;
	private Set<Stage> stages;
    
    public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}



	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @OneToMany(mappedBy="enterprise")
	public Set<Stage> getStages() {
		return stages;
	}

	public void setStages(Set<Stage> stages) {
		this.stages = stages;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
   /* private Long id;
    private String name;
    private String adress;
    private String postalCode;
    private String town;
    private String activity;
	private Set<Stage> stages;*/
	
	public void string() {
		System.out.println(name + adress + postalCode + town + activity);
	}

}