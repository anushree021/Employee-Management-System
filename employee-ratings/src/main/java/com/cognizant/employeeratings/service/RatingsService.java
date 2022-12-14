package com.cognizant.employeeratings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.employeeratings.model.Ratings;
import com.cognizant.employeeratings.repository.RatingsRepository;

@Service
public class RatingsService{
	
	@Autowired
	RatingsRepository ratingsRepository;

	public List<Ratings> getRatingsList() {
		return ratingsRepository.findAll();
	}
	

}
