package com.projet.annuaire.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Entity
@Table(name = "reply")
public class Reply {
    private Long id;
    private String reply;
	private Comment comment;
	private String username;
	private Set<Vote> votes;
	private Date date;
	private String formatedDate;
    private int vote = 0;
	

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
    
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(length = 1024)
	public String getReply() {
		return reply;
	}
	
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	@ManyToOne
	public Comment getComment() {
		return comment;
	}
	
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@OneToMany(mappedBy = "reply")
	public Set<Vote> getVotes() {
		return votes;
	}

	public void setVotes(Set<Vote> votes) {
		this.votes = votes;
	}

	public int getVote() {
		return vote;
	}
	
	public void setVote(int vote) {
		this.vote = vote;
	}

	@CreatedDate
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFormatedDate() {
		return formatedDate;
	}

	public void setFormatedDate(String formatedDate) {
		this.formatedDate = formatedDate;
	}
	
	public boolean isUpvotedByUser(String username) {
		for(Vote v : votes)
			if(v.getUser().getUsername().equals(username) && v.getValue()==1)
				return true;
		return false;
	}
	
	public boolean isDownvotedByUser(String username) {
		for(Vote v : votes)
			if(v.getUser().getUsername().equals(username) && v.getValue()==-1)
				return true;
		return false;
	}
}
