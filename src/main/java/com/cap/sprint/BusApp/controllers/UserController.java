package com.cap.sprint.BusApp.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@DeleteMapping("/delete/{username}")
	@ResponseStatus(HttpStatus.FOUND)
	public void deleteUser(@PathVariable("username") String username) {
		userService.deleteUser(username);
	}
	
	@PutMapping("/update/{username}:{password}")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void updateUser(@PathVariable("username") String username, @PathVariable("password") String password) {
		userService.updateUser(username, password);
	}
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
}
