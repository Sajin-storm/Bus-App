package com.cap.sprint.BusApp.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.BusRoute;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.exception.BookingAlreadyExistException;
import com.cap.sprint.BusApp.exception.BookingNotFoundException;
import com.cap.sprint.BusApp.exception.UserAlreadyExistException;
import com.cap.sprint.BusApp.exception.UserNotFoundException;
import com.cap.sprint.BusApp.repos.BookingRepository;
import com.cap.sprint.BusApp.repos.BusOperatorRepository;
import com.cap.sprint.BusApp.repos.FeedbackRepository;
import com.cap.sprint.BusApp.repos.UserRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	BusOperatorRepository busOperatorRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//addBooking(Booking):long
	public long addBooking(Booking booking) {
		Booking b1 = bookingRepository.findByUsername(booking.getUsername());
		if(b1 == null) {
			bookingRepository.save(booking);
		} 
		else {
			throw new BookingAlreadyExistException("User already exist");
		}
		return booking.getBookingId();
	}
	
	//updateBookingDate(long):boolean
//	public boolean updateBookingDate (Booking b) {
//		boolean result = false;
//		Booking b1 =null;
//		Optional<Booking> booking = bookingRepository.findById(b.getId());
//		if(booking.isPresent()) {
//			b1 = booking.get();
//			b1.setDate(b.getDate());
//			result = true;
//		} else {
//			throw new BookingNotFoundException("booking doesn't exist!!!");
//		}
//		return result;
//	}
	
	public boolean updateBookingDate(long bookingId) {
		boolean result = false;
		Optional<Booking> b = bookingRepository.findByBookingId(bookingId);
		Booking b1 = null;
		if(b.isPresent()) {
			b1 = b.get();
			b1.setDate(LocalDate.now());
			result = true;
		}
		return result;
	}
	
	//deleteBooking(long):boolean
	public boolean deleteBooking (long bookingid) {
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		Booking b = null;
		boolean result = false;
		if (booking.isPresent()) {
			b=booking.get();
			bookingRepository.delete(b);
			result = true;
		} else {
			throw new BookingNotFoundException("booking doesn't exist!!!");
		}
		return result;
	}
	
	//getBookingDetailsById(long):Booking
	public Booking getBookingDetailsById(long bookingid) {
		Booking b = null;
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
		if (booking.isPresent()) {
			b= booking.get();
		}
		return b;
	}
	
	//getAllBookingByDate(LocalDate):List<Booking>
	public List<Booking> getAllBookingByDate(LocalDate date){
		List<Booking> booking = bookingRepository.findByDate(date);
		return booking;
	}

	//getAllBookingByBusRoute(String):List<Booking>
	public List<Booking> getAllBookingByBusRoute(String routeName){
		List<Booking> booking = bookingRepository.findByBusRouteRouteName(routeName);
		return booking;
	}
	
	//getFeedbackByBusRoute(String):List<Booking>
	public List<Feedback> getFeedbackByBusRoute(String routeName){
		List<Feedback> feedback = feedbackRepository.findByRouteName(routeName);
		return feedback;
	}
	
	//own method to find all booking
	public List<Booking> findAllBookings(){
		List<Booking> booking = bookingRepository.findAll();
		if (booking.isEmpty()) {
			throw new BookingNotFoundException("bookings does not exist!!!");
		}
		return booking;
	}
	
	
	
	
	
	
	
	//addFeedback(User,Long):void
	public void addFeedback(User user,long bookingId) {
		Optional<Booking> booking = bookingRepository.findByBookingId(bookingId);
		Booking b = null;
		Feedback f = new Feedback();
		if(booking.isPresent()) {
			b = booking.get();
		} else {
			throw new BookingNotFoundException("Booking not found");
		}
		
		Optional<User> user1 = userRepository.findByUsername(user.getUsername());
		User u = null;
		if(user1.isPresent()) {
			u = user1.get();
		} else {
			throw new UserNotFoundException("User not found!!!");
		}
		
		
		f.setRouteName(b.getBusRoute().getRouteName());
		f.setUsername(u.getUsername());
		f.setUser(u);
		feedbackRepository.save(f);
 	}
	
	//addFeedback(String,long,String):void
	public void addFeedback(String username, long bookingid, String comment) {
	Optional<Booking> booking = bookingRepository.findByBookingId(bookingid);
	Feedback feedback = new Feedback();
	Booking b = null;
	if(booking.isPresent()) {
		b = booking.get();
	}
	
	Optional<User> user = userRepository.findByUsername(username);
	User u = null;
	if(user.isPresent()) {
		u = user.get();
	}

	feedback.setRouteName(b.getBusRoute().getRouteName());
	feedback.setComment(comment);
	feedback.setUsername(username);
	feedback.setUser(u);
	feedbackRepository.save(feedback);
	}
	
	
	
//	List<Feedback> f = feedbackRepository.findByUserUsername(username);
//	for (Feedback f1 : f) {
//		if(f1.getComment() == comment) {
//			f1.setRouteName(b.getBusRoute().getRouteName());
//			f1.setComment(comment);
//			f1.setUsername(username);
//			f1.setUser(u);
//			feedbackRepository.save(f1);
//		} else {
//			throw new UserNotFoundException("feedback already exist");
//		}
//	}
	
	//getAllBookingsById(String):List<Booking> 3 methods 
//	//busNumber
//	public List<Booking> getAllBookingByBusNumber(String s) {
//		List<Booking> booking = bookingRepository.findByBusNumber(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
//	
//	//source
//	public List<Booking> getAllBookingBySource(String s){
//		List<Booking> booking = bookingRepository.findBySource(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
//	
//	//destination
//	public List<Booking> getAllBookingByDestination(String s){
//		List<Booking> booking = bookingRepository.findByDestination(s);
//		if(booking.isEmpty()) {
//			throw new BookingNotFoundException("bookings not found!!!");
//		}
//		return booking;
//	}
	
	
}




