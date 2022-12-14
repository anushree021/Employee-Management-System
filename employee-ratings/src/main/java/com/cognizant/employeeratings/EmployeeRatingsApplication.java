package com.cognizant.employeeratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRatingsApplication.class, args);
	}

}
