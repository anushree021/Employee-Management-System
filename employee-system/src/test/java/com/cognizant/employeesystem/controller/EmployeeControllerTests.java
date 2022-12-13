package com.cognizant.employeesystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.employeesystem.model.Employee;
import com.cognizant.employeesystem.service.AuthorizationService;
import com.cognizant.employeesystem.service.EmployeeService;

@SpringBootTest
public class EmployeeControllerTests {
	
	@Mock
	EmployeeService employeeService;
	
	@Mock
	AuthorizationService authorizationService;
	
	@InjectMocks
	EmployeeController controller;
	
	@Test
	public void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void testHealthCheck() {
		assertEquals("Employee System Microservice is Active.", controller.healthCheck());
	}
	
	@Test
	public void testAuditChecklistQuestions() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"firstname","lastname","email","designation"));
		
		when(authorizationService.validateJwt("jwt")).thenReturn(true);
		
		when(employeeService.getAllEmployees()).thenReturn(employees);
		
		assertEquals(employees, controller.getAllEmployees("jwt"));		
	}
	

}
