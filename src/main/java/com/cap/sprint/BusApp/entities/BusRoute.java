package com.cap.sprint.BusApp.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BusRoute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String routeName;
	String source;
	String destination;
	
	@OneToMany(mappedBy = "busRoute", cascade = {CascadeType.ALL})
	List<Bus> bus;
	
	public BusRoute() {
		super();
	}

	public BusRoute(String routeName, String source, String destination, List<Bus> bus) {
		super();
		this.routeName = routeName;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRouteName() {
		return routeName;
	}

	public void setRouteName(String routeName) {
		this.routeName = routeName;
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

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusRoute [id=" + id + ", routeName=" + routeName + ", source=" + source + ", destination=" + destination
				+ ", bus=" + bus + "]";
	}
	
	
}
