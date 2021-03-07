package com.cap.sprint.BusApp.controllers;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.services.BookingService;

@RestController
@RequestMapping(path = "/bookings")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public long addBooking(@RequestBody Booking booking) {
		return bookingService.addBooking(booking);
	}
	
	@PutMapping("/update/{bookingId}")
	@Transactional
	public boolean updateBookingDate (@PathVariable("bookingId") long bookingId) {
		return bookingService.updateBookingDate(bookingId);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public boolean deleteBooking(@PathVariable("id") long id) {
		return bookingService.deleteBooking(id);
	}
	
	@GetMapping("/{bookingId}")
	@ResponseStatus(HttpStatus.FOUND)
	public Booking getBookingDetailsById(@PathVariable("bookingId") long bookingId) {
		return bookingService.getBookingDetailsById(bookingId);
	}
	
	@GetMapping("/date/{date}")
	public List<Booking> getAllBookingByDate(@PathVariable("date") String date){
		LocalDate d = LocalDate.parse(date); 
		return bookingService.getAllBookingByDate(d);
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Booking> findAllBookings (){
		return bookingService.findAllBookings();
	}
	
//	@GetMapping("/busNumber/{busNumber}")
//	@ResponseStatus(HttpStatus.FOUND)
//	public List<Booking> getAllBookingByBusNumber(@PathVariable("busNumber") String busNumber){
//		return bookingService.getAllBookingByBusNumber(busNumber);
//	}
//	
//	@GetMapping("/source/{source}")
//	@ResponseStatus(HttpStatus.FOUND)
//	public List<Booking> getAllBookingBySource(@PathVariable("source") String source){
//		return bookingService.getAllBookingBySource(source);
//	}
//	
//	@GetMapping("/destination/{destination}")
//	@ResponseStatus(HttpStatus.FOUND)
//	public List<Booking> getAllBookingByDestination(@PathVariable("destination") String destination){
//		return bookingService.getAllBookingByDestination(destination);
//	}
	
	@GetMapping("/routeName/{routeName}")
	public List<Booking> getAllBookingByBusRoute(@PathVariable("routeName") String routeName){
		return bookingService.getAllBookingByBusRoute(routeName);
	}
	
	@PostMapping("/feedback/{bookingId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFeedback(@RequestBody User user,@PathVariable("bookingId") long bookingId) {
		bookingService.addFeedback(user, bookingId);
	}
	
	@GetMapping("/feedback/routeName/{routeName}")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Feedback> getFeedbackByBusRoute(@PathVariable("routeName") String routeName){
		return bookingService.getFeedbackByBusRoute(routeName);
	}
	
	@PostMapping("/feedback/add/{username}:{bookingId}")
	@ResponseStatus(HttpStatus.CREATED)
	public void addFeedback(@PathVariable("username") String username, @PathVariable("bookingId") long bookingId, @RequestBody String comment) {
		bookingService.addFeedback(username, bookingId, comment);
	}
	
	
}
