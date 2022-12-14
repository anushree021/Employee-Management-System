package com.cognizant.employeesystem.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.employeesystem.exception.ResourceNotFoundException;
import com.cognizant.employeesystem.model.Employee;
import com.cognizant.employeesystem.service.AuthorizationService;
import com.cognizant.employeesystem.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AuthorizationService authorizationService;
	
	Logger logger = LoggerFactory.getLogger("Employee-Controller-Logger");
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(@RequestHeader("Authorization") String jwt){
		//return employeeService.getAllEmployees();
		
        List<Employee> employees = new ArrayList<Employee>();
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			employees = employeeService.getAllEmployees();
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return employees;
	}
	
	@GetMapping("/employees/ratings")
	public List<Employee> getAllEmployeesSortedByRatings(@RequestHeader("Authorization") String jwt){
		//return employeeService.getAllEmployeesSortedByRatings();
		
        List<Employee> employees = new ArrayList<Employee>();
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			employees = employeeService.getAllEmployeesSortedByRatings();
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return employees;
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@RequestHeader("Authorization") String jwt, @PathVariable(value="id") Long employeeId) throws ResourceNotFoundException{
		//return employeeService.getEmployeeById(employeeId);
		
        ResponseEntity<Employee> response = null;
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			response = employeeService.getEmployeeById(employeeId);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return response;
		
	}
	
	@PostMapping("/employees")
	public Employee createEmployee(@RequestHeader("Authorization") String jwt, @Validated @RequestBody Employee employee) {
		//return employeeService.createEmployee(employee);
		
        Employee emp = null;
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			emp = employeeService.createEmployee(employee);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return emp;
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestHeader("Authorization") String jwt, @PathVariable(value="id") Long employeeId, @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException{
		//return employeeService.updateEmployee(employeeId, employeeDetails);
		
        ResponseEntity<Employee> response = null;
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			response = employeeService.updateEmployee(employeeId, employeeDetails);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return response;
	}
	
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@RequestHeader("Authorization") String jwt, @PathVariable(value="id") Long employeeId)throws ResourceNotFoundException{
		//return employeeService.deleteEmployee(employeeId);
		
		Map<String, Boolean> response=new HashMap<>();
		
		logger.info("from header JWT :: " + jwt);
		
		// checking if the jwt is valid or not
		if(jwt.length()>0 && authorizationService.validateJwt(jwt)) {	
			response = employeeService.deleteEmployee(employeeId);
		}
		else {
			logger.error("Failed to validate the JWT :: " + jwt);
		}
		return response;
	}
	
	@GetMapping("/employees/health-check")
	public String healthCheck() {
		return "Employee System Microservice is Active.";
	}
	
}
