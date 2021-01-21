package com.spacex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Airport;

@Repository
public interface PassengerRepository extends JpaRepository<Airport, Long>{

}

