package com.cap.sprint.BusApp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pessenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String username;
	String firstName;
	String lastName;
	long phoneNumber;
	String email;
	long identityDocNumber;
	String identityDocName;
	
	@ManyToOne
	Booking booking;  //many passengers for in 1 booking
	
	public Pessenger() {
		super();
	}

	public Pessenger(String username, String firstName, String lastName, long phoneNumber, String email,
			long identityDocNumber, String identityDocName, Booking booking) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.identityDocNumber = identityDocNumber;
		this.identityDocName = identityDocName;
		this.booking = booking;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdentityDocNumber() {
		return identityDocNumber;
	}

	public void setIdentityDocNumber(long identityDocNumber) {
		this.identityDocNumber = identityDocNumber;
	}

	public String getIdentityDocName() {
		return identityDocName;
	}

	public void setIdentityDocName(String identityDocName) {
		this.identityDocName = identityDocName;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	@Override
	public String toString() {
		return "Pessenger [id=" + id + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", identityDocNumber=" + identityDocNumber
				+ ", identityDocName=" + identityDocName + ", booking=" + booking + "]";
	}
	
	
	
}
