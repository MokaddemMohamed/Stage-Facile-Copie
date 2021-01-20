package com.projet.annuaire.model;

import javax.persistence.*;
import java.util.Set;

/**
 * 
 * @author SCHAETZEL Robin
 *
 */
@Entity
@Table(name = "vote")
public class Vote {
	private Long id;
	private User user;
	private Reply reply;
	private int value;
	
	public Vote() {
	}
	
	public Vote(User user, Reply reply, int value) {
		this.user = user;
		this.reply = reply;
		this.value = value;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(name = "reply_id")
	public Reply getReply() {
		return reply;
	}

	public void setReply(Reply reply) {
		this.reply = reply;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}