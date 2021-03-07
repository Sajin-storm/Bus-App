package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.BusOperatorRequest;
import com.cap.sprint.BusApp.entities.BusRoute;
import com.cap.sprint.BusApp.exception.BusDoesnotExistException;
import com.cap.sprint.BusApp.repos.AdminRepository;
import com.cap.sprint.BusApp.repos.BookingRepository;
import com.cap.sprint.BusApp.repos.BusOperatorRepository;
import com.cap.sprint.BusApp.repos.BusOperatorRequestRepository;
import com.cap.sprint.BusApp.repos.BusRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	BusOperatorRepository busOperatorRepository;
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	BusRepository busRepository;
	
	@Autowired
	BusOperatorRequestRepository busOperatorRequestRepository;
	
	@Override
	public List<BusOperator> getAllBusOperator(){
		return busOperatorRepository.findAll();
	}
	
	@Override
	public List<BusOperator> getAllBusOperatorByRoute(String route){
		List<BusOperator> busOperator = busOperatorRepository.findByBusBusRouteRouteName(route);
		return busOperator;
	}
	
	@Override
	public List<BusOperatorRequest> getAllBusOperatorsRequest(){
		List<BusOperatorRequest> busOperatorRequest = busOperatorRequestRepository.findAll();
		return busOperatorRequest;
	}
	
	@Override
	public void updateBusTime(Bus bus,LocalTime startTime, LocalTime endTime) {
		Booking b = bookingRepository.findByBusBusNumber(bus.getBusNumber());
		b.setJourneyStartTime(startTime);
		b.setJourneyEndTime(endTime);
	}
	
	@Override
	public void updateBusRoute(Bus bus, BusRoute route) {
		Booking b = bookingRepository.findByBusBusNumber(bus.getBusNumber());
		b.setBusRoute(route);
	}
	
	@Override
	public void updateBusFare(Bus bus, int fare) {
		Bus b = busRepository.findByBusNumber(bus.getBusNumber());
		b.setFare(fare);
	}
	
	@Override
	public void deleteBus(Bus bus) {
		Optional<Bus> b = busRepository.findById(bus.getId());
		if(b.isPresent()) {
			busRepository.delete(bus);
		} else {
			throw new BusDoesnotExistException("Bus does not exist!!!");
		}
	}
	
	@Override
	public void deleteBusByOperator(String busOperatorUsername) {
		Optional<Bus> b = busRepository.findByBusOperatorBusOperatorUsername(busOperatorUsername);
		Bus bus = null;
		if(b.isPresent()) {
			bus =b.get();
			busRepository.delete(bus);
		} else {
			throw new BusDoesnotExistException("BusOperator does not exist!!!");
		}
	}
	
	@Override
	public int getRevenueByDate(LocalDate date) {
		int i = 0;
		List<Booking> booking = bookingRepository.findByDate(date);
		for (Booking b : booking) {
			i=i+b.getAmountPaid();
		}
		return i;
	}
	
	@Override
	public int getRevenueByBusRoute(String route) {
		int i = 0;
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(route);
		System.out.println(booking);
		for (Booking b: booking) {
			i=i+b.getAmountPaid();
		}
		return i;
	}
	
	@Override
	public int getRevenueByBusOperator(String busOperatorUsername) {
		int i = 0;
		List<Booking> booking = bookingRepository.findByBusBusOperatorBusOperatorUsername(busOperatorUsername);
		System.out.println(booking);
		for (Booking b: booking) {
			System.out.println(b);
			i=i+b.getAmountPaid();
		}
		
		System.out.print(i);
		return i;
	}
	
}

