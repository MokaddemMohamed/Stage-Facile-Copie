package com.projet.annuaire.model;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "comment")
public class Comment {
    private Long id;
    private String comments;
	private Stage stage;
    private int note;
    private Set<Reply> replies;
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 1024)
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comment) {
		this.comments = comment;
	}
	
	@OneToOne
	public Stage getStage() {
		return stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public int getNote() {
		return note;
	}
	
	public void setNote(int note) {
		this.note = note;
	}
	
	@OneToMany(mappedBy = "comment")
	public Set<Reply> getReplies() {
		return replies;
	}
	
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	
}
