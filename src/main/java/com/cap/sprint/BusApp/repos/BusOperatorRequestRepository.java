package com.cap.sprint.BusApp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.BusOperatorRequest;

@Repository
public interface BusOperatorRequestRepository extends JpaRepository<BusOperatorRequest,Integer>{

}
