package com.cognizant.employeeratings.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.employeeratings.feign.AuthorizationFeign;
import com.cognizant.employeeratings.model.AuthenticationResponse;

@SpringBootTest
class AuthorizationServiceTests {
	
	@Mock
	AuthorizationFeign authClient;
	
	@InjectMocks
	AuthorizationServiceImpl authorizationServiceImpl;
	
	@Test
	public void contextLoads() throws Exception {
		assertNotNull(authorizationServiceImpl);
	}
	
	@Test
	public void testValidateJwt() {
		AuthenticationResponse authenticationResponse = new AuthenticationResponse("null","null",true);
		ResponseEntity<AuthenticationResponse> response = new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
		when(authClient.validate("jwt")).thenReturn(response);
		assertTrue(authorizationServiceImpl.validateJwt("jwt"));
	}
	

}
