package com.cap.sprint.BusApp.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.sprint.BusApp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	public Optional<User> findByUsername(String username);


}
