package com.cap.sprint.BusApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class BusDoesnotExistException extends RuntimeException{
	
	public BusDoesnotExistException() {
	}
	
	public BusDoesnotExistException(String message) {
		super(message);
	}

}