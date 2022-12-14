package com.cognizant.employeesystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.employeesystem.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	//@Query(value="SELECT e from Employees e WHERE e.id=?1")
	//Employee getEmployeeById(Long employeeId);
	
	//List<Employee> findByOrderByRatingDesc();

}
