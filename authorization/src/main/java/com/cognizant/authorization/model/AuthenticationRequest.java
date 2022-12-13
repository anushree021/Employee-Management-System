package com.cognizant.authorization.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@ToString
public class AuthenticationRequest {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
}
