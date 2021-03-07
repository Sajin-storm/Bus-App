package com.cap.sprint.BusApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.exception.BusAlreadyExistException;
import com.cap.sprint.BusApp.repos.BusOperatorRepository;

@Service
public class BusOperatorService {
	
	@Autowired
	BusOperatorRepository busOperatorRepository;
	
	
//	public void addBus(Bus bus) {
//		Bus b = busOperatorRepository.findByBus(bus);
//		if(b == null) {
//			busOperatorRepository.save(bus);
//		} else {
//			throw new BusAlreadyExistException("Bus already exists!!!");
//		}
//	}
	
}
