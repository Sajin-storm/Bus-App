package com.cap.sprint.BusApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.CONFLICT)
public class BusAlreadyExistException extends RuntimeException{
	
	public BusAlreadyExistException() {
	}
	
	public BusAlreadyExistException(String message) {
		super(message);
	}

}