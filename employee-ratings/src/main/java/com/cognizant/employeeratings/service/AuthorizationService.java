package com.cognizant.employeeratings.service;

public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
