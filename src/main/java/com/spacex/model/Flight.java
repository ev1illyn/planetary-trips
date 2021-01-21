package com.spacex.model;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long number;
	
	private int availableSeats;
	
	private Double duration;
	
	private HashMap<Passenger, Double> priceByPassenger;
	
	@OneToOne
	private Local destination;

	@OneToOne
	private Local departure;
	
	private LocalDateTime arrivalDate;
	
	private LocalDateTime departureDate;
	
	@ManyToOne
	private Airport airport;
	
}
