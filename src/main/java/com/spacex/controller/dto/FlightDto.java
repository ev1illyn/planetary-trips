package com.spacex.controller.dto;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.data.domain.Page;

import com.spacex.model.Flight;
import com.spacex.model.Local;

public class FlightDto {

	private Long id;

	private Long number;
	
	private int availableSeats;
	
	private LocalTime duration;
	
	private Local destination;
	
	private Local departure;
	
	private LocalDateTime arrivalDate;
	
	private LocalDateTime departureDate;

	private String arrivalAirport;
	
	private String departureAirport;
	
	public FlightDto(Flight flight) {
		super();
		this.id = flight.getId();
		this.number = flight.getNumber();
		this.availableSeats = flight.getAvailableSeats();
		this.duration = flight.getDuration();
		this.destination = flight.getDestination();
		this.departure = flight.getDeparture();
		this.arrivalDate = flight.getArrivalDate();
		this.departureDate = flight.getDepartureDate();
		this.arrivalAirport = flight.getArrivalAirport().getName();
		this.departureAirport = flight.getDepartureAirport().getName();
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

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
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

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public static Page<FlightDto> convertList(Page<Flight> flights) {
		return flights.map(FlightDto::new);
	}
}