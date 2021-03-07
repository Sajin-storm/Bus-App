package com.cap.sprint.BusApp.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.sprint.BusApp.entities.Bus;
import com.cap.sprint.BusApp.entities.BusOperator;
import com.cap.sprint.BusApp.entities.BusOperatorRequest;
import com.cap.sprint.BusApp.entities.BusRoute;
import com.cap.sprint.BusApp.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/getAll")
	@ResponseStatus(HttpStatus.FOUND)
	public List<BusOperator> getAllBusOperator(){
		return adminService.getAllBusOperator();
	}
	
	@GetMapping("/getByRoute/{route}")
	@ResponseStatus(HttpStatus.FOUND)
	public List<BusOperator> getAllBusOperatorByRoute(@PathVariable("route")String route){
		return adminService.getAllBusOperatorByRoute(route);
	}
	
	@GetMapping("/getRequest")
	@ResponseStatus(HttpStatus.FOUND)
	public List<BusOperatorRequest> getAllBusOperatorsRequest(){
		return adminService.getAllBusOperatorsRequest();
	}
	
	@PutMapping("/updateTime/{startTime}:{endTime}")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void updateBusTime(@RequestBody Bus bus,@PathVariable("startTime")LocalTime startTime,@PathVariable("endTime") LocalTime endTime) {
		adminService.updateBusTime(bus, startTime, endTime);
	}
	
	@PutMapping("/updateBusRoute/{route}")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void updateBusRoute(@RequestBody Bus bus,@PathVariable("route") BusRoute route) {
		adminService.updateBusRoute(bus, route);
	}
	
	@PutMapping("/updateBusFare/{fare}")
	@Transactional
	@ResponseStatus(HttpStatus.CREATED)
	public void updateBusFare(@RequestBody Bus bus,@PathVariable("fare") int fare) {
		adminService.updateBusFare(bus, fare);
	}
	
	@DeleteMapping("/deleteBus/")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBus(@RequestBody Bus bus) {
		adminService.deleteBus(bus);
	}
	
	@DeleteMapping("/deleteByOperator/{operator}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBusByOperator(@PathVariable("operator")String operator) {
		adminService.deleteBusByOperator(operator);
	}
	
	@GetMapping("getRevenueByDate/{date}")
	@ResponseStatus(HttpStatus.FOUND)
	public int getRevenueByDate(@PathVariable("date") LocalDate date) {
		return adminService.getRevenueByDate(date);
	}
	
	@GetMapping("/getRevenueByBusRoute/{route}")
	@ResponseStatus(HttpStatus.FOUND)
	public int getRevenueByBusRoute(@PathVariable("route") String route) {
		return adminService.getRevenueByBusRoute(route);
	}
		
	@GetMapping("/getRevenueByBusOperator/{busOperatorUsername}")
	@ResponseStatus(HttpStatus.FOUND)
	public int getRevenueByBusOperator(@PathVariable("busOperatorUsername") String busOperatorUsername) {
		return adminService.getRevenueByBusOperator(busOperatorUsername);
	}

}
