package com.cognizant.employeeratings.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeeratings.model.Ratings;
import com.cognizant.employeeratings.service.AuthorizationService;
import com.cognizant.employeeratings.service.RatingsService;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "*")
public class RatingsController {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private RatingsService ratingsService;
	
	Logger logger = LoggerFactory.getLogger("Ratings-Controller-Logger");

	
	// Endpoint to retrieve the Audit Benchmark details
	@GetMapping("/ratings-list")
	public List<Ratings> getRatingsList(@RequestHeader("Authorization") String jwt) {
		List<Ratings> ratings = new ArrayList<>();
		
		// checking if the jwt is valid or not
		logger.info("from header JWT :: " + jwt);
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {			
			ratings = ratingsService.getRatingsList();
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return ratings;
	}
	
	// Endpoint to check if the microservice is live
	@GetMapping("/health-check")
	public String healthCheck() {
		return "Employee Ratings Microservice is Active.";
	}
	

}
