package com.cognizant.employeeratings.service;

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
import com.cognizant.employeeratings.repository.RatingsRepository;

@SpringBootTest
class RatingsServiceTests {
	
	@Mock
	RatingsRepository ratingsRepository;
	
	@InjectMocks
	RatingsService ratingsService;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(ratingsService);
	}
	
	@Test
	public void testGetRatingsList() {
		List<Ratings> ratingsList = new ArrayList<>();
		ratingsList.add(new Ratings(1,1,"review"));
		
		when(ratingsRepository.findAll()).thenReturn(ratingsList);
		
		assertEquals(ratingsList, ratingsService.getRatingsList());
	}
	

}
