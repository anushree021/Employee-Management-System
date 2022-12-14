package com.cognizant.employeeratings.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.employeeratings.model.Ratings;
import com.cognizant.employeeratings.service.AuthorizationService;
import com.cognizant.employeeratings.service.RatingsService;

@SpringBootTest
class RatingsControllerTests {
	
	@Mock
	RatingsService ratingsService;
	
	@Mock
	AuthorizationService authorizationService;
	
	@InjectMocks
	RatingsController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(controller);
	}
	
	@Test
	public void testHealthCheck() {
		assertEquals("Employee Ratings Microservice is Active.",controller.healthCheck());
	}
	
	@Test
	public void testGetRatingsList() {
		List<Ratings> ratingsList = new ArrayList<>();
		ratingsList.add(new Ratings(1,1,"review"));
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		when(ratingsService.getRatingsList()).thenReturn(ratingsList);
		
		assertEquals(ratingsList, controller.getRatingsList("jwt"));
	}
	

}
