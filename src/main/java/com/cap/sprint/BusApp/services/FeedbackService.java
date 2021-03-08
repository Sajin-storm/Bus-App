package com.cap.sprint.BusApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.Feedback;
import com.cap.sprint.BusApp.entities.User;
import com.cap.sprint.BusApp.exception.UserNotFoundException;
import com.cap.sprint.BusApp.repos.BusOperatorRepository;
import com.cap.sprint.BusApp.repos.FeedbackRepository;
import com.cap.sprint.BusApp.repos.UserRepository;

@Service
public class FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BusOperatorRepository busOperatorRepository;
	
	public Feedback addFeedback(Feedback feedback) {
		Feedback f =null;
		Optional<User> user = userRepository.findByUsername(feedback.getUsername());
		if(user.isPresent()) {
			feedback.setUser(user.get());
			f = feedbackRepository.save(feedback);
		} else {
			throw new UserNotFoundException("User not found!!!");
		}
		return f;
	}
	
	
	public List<Feedback> viewAllFeedbacks(String routeName , BusOperator busOperator){
		List<Feedback> f1 = feedbackRepository.findByRouteName(routeName);
		return f1;
	}
	
	public List<Feedback> viewAllFeedbacks(BusOperator busOperator){
		List<Feedback> feedback = feedbackRepository.findByBusOperatorBusOperatorUsername(busOperator.getBusOperatorusername());
		return feedback;
	}
	
	
	
	
	
	public List<Feedback> getAllFeedbacks(){
		List<Feedback> feedback = feedbackRepository.findAll();
		return feedback;
	}
	
}
