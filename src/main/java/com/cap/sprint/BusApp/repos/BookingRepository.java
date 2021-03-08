package com.cap.sprint.BusApp.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Bus;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer>{

	public Optional<Booking> findById(int id);
	public Booking findByUsername(String username);
	public List<Booking> findByDate(LocalDate date);
	public Optional<Booking> findByBookingId(long id);
	public List<Booking> findByBusNumber(String busNumber);
	public List<Booking> findBySource(String source);
	public List<Booking> findByDestination(String destination);
	public List<Booking> findByBusRouteRouteName(String routeName);
	public Booking findByBusBusNumber(String busNumber);
	public List<Booking> findByBusBusOperatorBusOperatorUsername(String busOperatorUsername);
	
	public List<Booking> findByBusRouteRouteNameAndDate(String routeName, LocalDate date);

}
