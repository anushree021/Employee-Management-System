package com.cognizant.employeesystem.service;

public interface AuthorizationService {
	
	public boolean validateJwt(String jwt);
}
