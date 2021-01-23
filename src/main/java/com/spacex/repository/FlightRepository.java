package com.spacex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

	Flight findByNumber(Long number);
	
}

