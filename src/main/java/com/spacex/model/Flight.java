package com.spacex.model;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private Long id;
	
	private Long number;
	
	private int availableSeats;
	
	private Double duration;
	
	private HashMap<Passenger, Double> priceByPassenger;
	
	private Local destination;

	private Local departure;
	
	private LocalDateTime arrivalDate;
	
	private LocalDateTime departureDate;
	
	private Airport airport;
	
}
