package com.spacex.controller.form;

import java.util.HashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Client;
import com.spacex.model.Flight;
import com.spacex.model.FlightBooking;
import com.spacex.model.Passenger;
import com.spacex.repository.ClientRepository;
import com.spacex.repository.FlightRepository;

public class FlightBookingForm {

	@NotNull
	@NotEmpty
	private HashMap<Passenger, Double> passengers;

	@NotNull
	@NotEmpty
	@Length(min = 50, max = 10)
	private Double price;
	
	@NotNull
	@NotEmpty
	private Long flightNumber;

	@NotNull
	@NotEmpty
	private String clientName;

	public HashMap<Passenger, Double> getPassengers() {
		return passengers;
	}

	public void setPassengers(HashMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(Long flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public FlightBooking convert(FlightRepository flightRepository,
			ClientRepository clientRepository) {
		Flight flight = flightRepository.findByNumber(flightNumber);
		Client client = clientRepository.findByNameContaining(clientName);
		return new FlightBooking(passengers, price, flight, client);
	}
	
}
