package com.projet.annuaire.model;

import java.util.Set;

import javax.persistence.*;
/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "userArchive")
public class UserArchive {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
	private String firstName;
	private String lastName;
	private String mail;
	private String tel;
	private String birthday;
    private Set<Role> roles;
    private String role;
    private Set<Stage> stages;
    
    
    @OneToMany(mappedBy="user")
    public Set<Stage> getStages() {
		return stages;
	}
	public void setStages(Set<Stage> stages) {
		this.stages = stages;
	}
	public UserArchive() {
    	super();
    }
    public UserArchive(String string, String string2) {
		this.firstName = string;
		this.mail = string2;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
	@ManyToMany
    @JoinTable(name = "useres_role", joinColumns = @JoinColumn(name = "useres_id"), inverseJoinColumns = @JoinColumn(name = "rolees_id"))
    public Set<Role> getRoles() {
        return roles;
    }

    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void string() {
	System.out.println(id +"u "+ username + "f "+firstName+ "l "+lastName + "m "+ mail+"t "+ tel+"b "+birthday);
}
	
	public boolean Teacher() {
		if(role.contains("Teacher"))
			return true;
		return false;
	}
}