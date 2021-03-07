package com.cap.sprint.BusApp.entities;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String adminUsername;
	String password;
	ArrayList<Integer> caseNumber;
	
	public AdminUser(){
		super();
	}

	public AdminUser(String adminUsername, String password, ArrayList<Integer> caseNumber) {
		super();
		this.adminUsername = adminUsername;
		this.password = password;
		this.caseNumber = caseNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
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

	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", adminUsername=" + adminUsername + ", password=" + password + ", caseNumber="
				+ caseNumber + "]";
	}
	
}
