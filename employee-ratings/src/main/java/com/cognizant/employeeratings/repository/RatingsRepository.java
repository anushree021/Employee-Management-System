package com.cognizant.employeeratings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.employeeratings.model.Ratings;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Long>{

}
