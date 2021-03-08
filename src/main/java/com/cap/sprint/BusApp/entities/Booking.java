package com.cap.sprint.BusApp.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	long bookingId;
	String username;
	String busNumber;
	String source;
	String destination;
	int numberOfSeats;
	int amountPaid;
	LocalDate date;
	LocalTime journeyStartTime;
	LocalTime journeyEndTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	User user; //many bookings can be done by 1 user  or 1 user can book many bookings
	
	@ManyToOne(cascade = CascadeType.ALL)
	BusRoute busRoute;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Bus bus;
	
	public Booking() {
		super();
	}

	public Booking(long bookingId, String username, String busNumber, String source, String destination,
			int numberOfSeats, int amountPaid, LocalDate date, LocalTime journeyStartTime, LocalTime journeyEndTime,User user,BusRoute busRoute,Bus bus ) {
		super();
		this.bookingId = bookingId;
		this.username = username;
		this.busNumber = busNumber;
		this.source = source;
		this.destination = destination;
		this.numberOfSeats = numberOfSeats;
		this.amountPaid = amountPaid;
		this.date = date;
		this.journeyStartTime = journeyStartTime;
		this.journeyEndTime = journeyEndTime;
		this.user=user;
		this.busRoute=busRoute;
		this.bus=bus;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
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

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getJourneyStartTime() {
		return journeyStartTime;
	}

	public void setJourneyStartTime(LocalTime journeyStartTime) {
		this.journeyStartTime = journeyStartTime;
	}

	public LocalTime getJourneyEndTime() {
		return journeyEndTime;
	}

	public void setJourneyEndTime(LocalTime journeyEndTime) {
		this.journeyEndTime = journeyEndTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}
	
	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingId=" + bookingId + ", username=" + username + ", busNumber=" + busNumber
				+ ", source=" + source + ", destination=" + destination + ", numberOfSeats=" + numberOfSeats
				+ ", amountPaid=" + amountPaid + ", date=" + date + ", journeyStartTime=" + journeyStartTime
				+ ", journeyEndTime=" + journeyEndTime + ", user=" + user + ", busRoute=" + busRoute + "]";
	}

	
}
