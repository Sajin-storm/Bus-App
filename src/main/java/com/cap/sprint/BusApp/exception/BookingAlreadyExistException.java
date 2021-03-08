package com.cap.sprint.BusApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class BookingAlreadyExistException extends RuntimeException {
	
	public BookingAlreadyExistException() {
		
	}
	
	public BookingAlreadyExistException(String message) {
		super(message);
	}
}
