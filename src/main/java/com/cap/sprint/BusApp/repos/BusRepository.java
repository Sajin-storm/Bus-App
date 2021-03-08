package com.cap.sprint.BusApp.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,Integer>{

	Bus findByBusNumber(String busNumber);

	Bus findByBusOperatorBusOperatorUsername(String busOperatorUsername);

}
