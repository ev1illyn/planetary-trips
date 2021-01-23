package com.spacex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.FlightStatus;

@Repository
public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long>{

}

