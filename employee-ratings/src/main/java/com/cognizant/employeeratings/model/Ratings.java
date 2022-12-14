package com.cognizant.employeeratings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ratings")
public class Ratings
{
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;
	
	@Column(name="rating")
	private long rating;
	
	@Column(name="review")
	private String review;
	

}
