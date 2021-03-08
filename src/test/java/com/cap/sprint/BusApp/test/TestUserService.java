package com.cap.sprint.BusApp.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.services.UserService;

@SpringBootTest
class TestUserService {
	
	@Autowired
	UserService userService;
	
	@Test
	void testAddUser() {
		User user = new User();
		user.setUsername("Ramesh");
		user.setPassword("Ramesh123");
		userService.addUser(user);
	}

	@Test
	void testDeleteUser() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllUsers() {
		fail("Not yet implemented");
	}

}
