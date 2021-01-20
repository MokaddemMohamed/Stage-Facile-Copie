package com.projet.annuaire.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author LE Dan
 *
 */
@Entity
@Table(name = "commentArchive")
public class CommentArchive {
    private Long id;
    private String comments;
	private Stage stage;
    private int note;
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comment) {
		this.comments = comment;
	}
	
	@ManyToOne
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
}
