package com.cognizant.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.authorization.exception.ProjectManagerNotFoundException;
import com.cognizant.authorization.model.ProjectManager;
import com.cognizant.authorization.repository.ProjectManagerRepo;

@Service
public class ProjectManagerService {

	@Autowired
	private ProjectManagerRepo projectManagerRepo;
	
	public ProjectManager getProjectManagerByUserName(String username) throws ProjectManagerNotFoundException{
		ProjectManager projectManager = null;
		projectManager = projectManagerRepo.getProjectManagerByUserName(username);
		if(projectManager==null) {
			throw new ProjectManagerNotFoundException("Given Project-Manager-Details does not exist in our Database!!");
		}
		return projectManager;
	}
}