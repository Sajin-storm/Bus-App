package com.cap.sprint.BusApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class BusOperatorAlreadyExistsException extends RuntimeException {
	
	public BusOperatorAlreadyExistsException() {
		
	}
	
	public BusOperatorAlreadyExistsException(String message) {
		super(message);
	}
	
}
