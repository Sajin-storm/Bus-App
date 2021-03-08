package com.cap.sprint.BusApp.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.Booking;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.BusOperatorRequest;


@Repository
public interface BusOperatorRepository extends JpaRepository<BusOperator,Integer>{


	public List<BusOperator> findByBusBusRouteRouteName(String route);

	public BusOperator findByBusOperatorUsername(String busOperatorUsername);

	public BusOperator findByPassword(String oldPassword);

	
	
	
	
	

}
