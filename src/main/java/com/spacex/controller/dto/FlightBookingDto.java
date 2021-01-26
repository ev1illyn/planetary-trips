package com.spacex.controller.dto;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.data.domain.Page;

import com.spacex.model.Client;
import com.spacex.model.Flight;
import com.spacex.model.FlightBooking;
import com.spacex.model.Passenger;

public class FlightBookingDto {

	private Long id;
	
	private HashMap<Passenger, Double> passengers;
	
	private Double price;
	
	private Flight flight;
	
	private Client client;
	
	private LocalDateTime bookingDate = LocalDateTime.now();

	public FlightBookingDto(FlightBooking flightBooking) {
		super();
		this.id = flightBooking.getId();
		this.passengers = flightBooking.getPassengers();
		this.price = flightBooking.getPrice();
		this.flight = flightBooking.getFlight();
		this.client = flightBooking.getClient();
		this.bookingDate = flightBooking.getBookingDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public static Page<FlightBookingDto> convertList(Page<FlightBooking> flightBookings) {
		return flightBookings.map(FlightBookingDto::new);
	}
}
