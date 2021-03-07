package com.cap.sprint.BusApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.services.FeedbackService;

@RestController
@RequestMapping(path = "/feedbacks")
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackService;
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackService.addFeedback(feedback);
	}
	
	@GetMapping("/routeName/{routeName}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Feedback> viewAllBookings(@PathVariable String routeName){
		return feedbackService.viewAllFeedbacks(routeName, null);
	}
	
	
	
	
	@GetMapping("/")
	@ResponseStatus(HttpStatus.FOUND)
	public List<Feedback> getAllFeedbacks(){
		return feedbackService.getAllFeedbacks();
	}
	

}
