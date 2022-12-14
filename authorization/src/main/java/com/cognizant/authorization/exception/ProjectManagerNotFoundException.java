package com.cognizant.authorization.exception;

public class ProjectManagerNotFoundException extends RuntimeException{
	
	public static final long serialVersionUID = 1L;
	
	public ProjectManagerNotFoundException(String message) {
		super(message);
	}

}
