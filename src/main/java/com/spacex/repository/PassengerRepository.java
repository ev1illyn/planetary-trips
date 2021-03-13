package com.spacex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

	Passenger findByName(String name);
	
	Passenger findByNameContaining(String name);
	
	Page<Passenger> findByName(String name, Pageable pagination);
	
}
