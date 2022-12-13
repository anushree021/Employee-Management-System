package com.cognizant.employeesystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cognizant.employeesystem.exception.ResourceNotFoundException;
import com.cognizant.employeesystem.model.Employee;
import com.cognizant.employeesystem.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeServiceTests {
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Test
	void contextLoads() {
		assertNotNull(employeeService);
	}
	
	@Test
	void testGetAllEmployees() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"firstname","lastname","email","designation"));
		
		when(employeeRepository.findAll()).thenReturn(employees);
		assertEquals(employees, employeeService.getAllEmployees());
	}
	
	/*@Test
	void testGetEmployeeById() throws ResourceNotFoundException {
		Employee employee=new Employee(1,"firstname","lastname","email","designation");
		ResponseEntity<Employee> response = new ResponseEntity<Employee>(employee, HttpStatus.OK);
		Long employeeId = (long) 1;
		
		//when(employeeRepository.findById(employeeId)).thenReturn(employee);
		doReturn(employee).when(employeeRepository).findById(employeeId);
		assertEquals(response, employeeService.getEmployeeById(employeeId));
	}*/
	
	@Test
	void testCreateEmployee() {
		Employee employee=new Employee(1,"firstname","lastname","email","designation");
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertEquals(employee, employeeService.createEmployee(employee));
	}

}
