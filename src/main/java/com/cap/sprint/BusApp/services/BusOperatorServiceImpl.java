package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.exception.BusAlreadyExistException;
import com.cap.sprint.BusApp.exception.BusOperatorAlreadyExistsException;
import com.cap.sprint.BusApp.repos.BookingRepository;
import com.cap.sprint.BusApp.repos.BusOperatorRepository;
import com.cap.sprint.BusApp.repos.BusRepository;

@Service
public class BusOperatorServiceImpl implements BusOperatorService{
	
	@Autowired
	BusOperatorRepository busOperatorRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	//Method to add a Bus into Bus Repository
	@Override
	public void addBus(Bus b) {
		Bus bus = busRepository.findByBusNumber(b.getBusNumber());
		if(bus == null) {
			busRepository.save(b); //In-built function to input/update the value into database
		}
		else {
			throw new BusAlreadyExistException("Bus with following number already exists: " + b.getBusNumber());
		}
	}
	
	//Method to retrieve the revenue generated from a particular Bus Route
	@Override
	public int getRevenueByBusRoute(String routeName){
		int revenue = 0;
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName); //Creating a list of bookings
		for(int i = 0; i < booking.size(); i++) {
			revenue = revenue + booking.get(i).getAmountPaid(); //Fetching the amount paid column from the list to add to revenue
		}
		return revenue;
	}
	
	//Method to retrieve the revenue generated from a particular Bus Route with date
	@Override
	public int getRevenueByBusRouteAndDate(String routeName, LocalDate date){
		int revenue = 0;
		List<Booking> booking = bookingRepository.findByBusRouteRouteNameAndDate(routeName, date); //Creating a list of bookings
		for(int i = 0; i < booking.size(); i++) {
			revenue = revenue + booking.get(i).getAmountPaid(); //Fetching the amount paid column from the list to add to revenue
		}
		return revenue;
	}
	
	//Method to retrieve the monthly revenue generated from a particular Bus Route
	@Override
	public int getMonthlyRevenueByBusRoute(String routeName, String month){
		int monthlyRevenue = 0;
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName); //Creating a list of bookings
		for(int i = 0; i < booking.size(); i++) {
			if(booking.get(i).getDate().getMonthValue() == Integer.parseInt(month)) //Finding particular month
				monthlyRevenue = monthlyRevenue + booking.get(i).getAmountPaid(); //Fetching the amount paid column from the list to add to revenue
		}
		return monthlyRevenue;
	}
	
	//Method to retrieve the yearly revenue generated from a particular Bus Route
	@Override
	public int getYearlyRevenueByBusRoute(String routeName, String year){
		int yearlyRevenue = 0;
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName); //Creating a list of bookings
		for(int i = 0; i < booking.size(); i++) {
			if(booking.get(i).getDate().getYear() == Integer.parseInt(year)) //Finding particular year
				yearlyRevenue = yearlyRevenue + booking.get(i).getAmountPaid(); //Fetching the amount paid column from the list to add to revenue
		}
		return yearlyRevenue;
	}
	
	//Method to add a Bus Operator to the BusOperator Repository
	@Override
	public void addBusOperator(BusOperator busOp) {
		BusOperator busOperator = busOperatorRepository.findByBusOperatorUsername(busOp.getBusOperatorUsername());
		if(busOperator == null) {
			busOperatorRepository.save(busOp); //In-built function to input/update the value into database
		}
		else {
			throw new BusOperatorAlreadyExistsException("Bus Operator with following id already exists: " + busOp.getId());
		}
	}
	
	//Method to update the password of a Bus Operator
	@Override
	public void updatePassword(String oldPassword, String newPassword) {
		BusOperator busOperator = busOperatorRepository.findByPassword(oldPassword);
		busOperator.setPassword(newPassword); //Updating the password using setters
	}
	
}
