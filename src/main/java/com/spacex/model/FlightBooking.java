package com.spacex.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class FlightBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private HashMap<Passenger, Double> passengers;
	
	private Double price;
	
	@ManyToOne
	private Flight flight;
	
	@ManyToOne
	private Client client;
}
