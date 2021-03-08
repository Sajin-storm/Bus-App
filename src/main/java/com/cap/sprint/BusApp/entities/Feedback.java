package com.cap.sprint.BusApp.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	int rating;
	String comment;
	String username;
	String routeName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	User user;
	
	@ManyToOne(cascade = CascadeType.ALL)
	BusOperator busOperator;
	
	public Feedback() {
		super();
	}

	public Feedback(int rating, String comment, String username, String routeName,User user,BusOperator busOperator) {
		super();
		this.rating = rating;
		this.comment = comment;
		this.username = username;
		this.routeName = routeName;
		this.user = user;
		this.busOperator=busOperator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public BusOperator getBusOperator() {
		return busOperator;
	}

	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", rating=" + rating + ", comment=" + comment + ", username=" + username
				+ ", routeName=" + routeName + ", user=" + user + "]";
	}

	
}
