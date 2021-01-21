package com.spacex.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FlightBooking {

	@Id
	private Long id;
	
	private HashMap<Passenger, Double> passengers;
	
	private Double price;
	
	private Flight flight;
	
	private Client client;
}
