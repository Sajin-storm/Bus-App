package com.cap.sprint.BusApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.BusApp.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/{busOperatorUsername}")
	public int getRevenueByBusOperator(@PathVariable("busOperatorUsername") String busOperatorUsername) {
		return adminService.getRevenueByBusOperator(busOperatorUsername);
	}
	
	@GetMapping("/r/{route}")
	public int getRevenueByBusRoute(@PathVariable("route") String route) {
		return adminService.getRevenueByBusRoute(route);
	}
	
}
