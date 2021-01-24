package com.spacex.controller.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.spacex.model.Flight;
import com.spacex.model.Local;
import com.spacex.model.Passenger;

public class FlightDto {

	private Long id;

	private Long number;
	
	private int availableSeats;
	
	private Double duration;
	
	private HashMap<Passenger, Double> priceByPassenger;
	
	private Local destination;
	
	private Local departure;
	
	private LocalDateTime arrivalDate;
	
	private LocalDateTime departureDate;

	public FlightDto(Flight flight) {
		super();
		this.id = flight.getId();
		this.number = flight.getNumber();
		this.availableSeats = flight.getAvailableSeats();
		this.duration = flight.getDuration();
		this.priceByPassenger = flight.getPriceByPassenger();
		this.destination = flight.getDestination();
		this.departure = flight.getDeparture();
		this.arrivalDate = flight.getArrivalDate();
		this.departureDate = flight.getDepartureDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public HashMap<Passenger, Double> getPriceByPassenger() {
		return priceByPassenger;
	}

	public void setPriceByPassenger(HashMap<Passenger, Double> priceByPassenger) {
		this.priceByPassenger = priceByPassenger;
	}

	public Local getDestination() {
		return destination;
	}

	public void setDestination(Local destination) {
		this.destination = destination;
	}

	public Local getDeparture() {
		return departure;
	}

	public void setDeparture(Local departure) {
		this.departure = departure;
	}

	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	public static List<FlightDto> convertList(List<Flight> flights) {
		return flights.stream().map(FlightDto::new).collect(Collectors.toList());
	}
}