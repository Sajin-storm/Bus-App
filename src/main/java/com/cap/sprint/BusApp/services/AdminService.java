package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.BusOperatorRequest;
import com.cap.sprint.BusApp.entities.BusRoute;

public interface AdminService {
	
	public List<BusOperator> getAllBusOperator();
	
	public List<BusOperator> getAllBusOperatorByRoute(String route);
	
	public List<BusOperatorRequest> getAllBusOperatorsRequest();
	
	public void updateBusTime(Bus bus,LocalTime startTime, LocalTime endTime);
	
	public void updateBusRoute(Bus bus, BusRoute route);
	
	public void updateBusFare(Bus bus, int fare);
	
	public void deleteBus(Bus bus);
	
	public void deleteBusByOperator(String operator);
	
	public int getRevenueByDate(LocalDate date);
	
	public int getRevenueByBusRoute(String route);
	
	public int getRevenueByBusOperator(String operator);
}
