package com.cap.sprint.BusApp.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BusOperator {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String busOperatorUsername;
	String password;
	ArrayList<Integer> caseNumber;
	
	@OneToOne
	Feedback feedback; 
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Bus bus;
	
	public BusOperator() {
		super();
	}

	public BusOperator(int id, String busOperatorUsername, String password, ArrayList<Integer> caseNumber,
			Feedback feedback, Bus bus) {
		super();
		this.id = id;
		this.busOperatorUsername = busOperatorUsername;
		this.password = password;
		this.caseNumber = caseNumber;
		this.feedback = feedback;
		this.bus = bus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusOperatorUsername() {
		return busOperatorUsername;
	}

	public void setBusOperatorUsername(String busOperatorUsername) {
		this.busOperatorUsername = busOperatorUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Integer> getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(ArrayList<Integer> caseNumber) {
		this.caseNumber = caseNumber;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusOperator [id=" + id + ", busOperatorUsername=" + busOperatorUsername + ", password=" + password
				+ ", caseNumber=" + caseNumber + ", feedback=" + feedback + "]";
	}
	
}
