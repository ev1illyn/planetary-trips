package com.spacex.controller.form;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spacex.model.Airport;
import com.spacex.model.Flight;
import com.spacex.model.Local;
import com.spacex.repository.AirportRepository;
import com.spacex.repository.FlightRepository;
import com.spacex.repository.LocalRepository;

public class FlightUpdateForm {

	@NotNull
	private Long number;

	@NotNull
	@Min(5)
	@Max(50)
	private int availableSeats;

	@NotNull
	private LocalTime duration;
	
	@NotNull
    @Column(columnDefinition = "Decimal(3,1) default '5.0'")
	private Double childDiscount;
	
	@NotNull
	@NotEmpty
	private String destinationCityName;

	@NotNull
	@NotEmpty
	private String departureCityName;

	@NotNull
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime arrivalDate;

	@NotNull
	@Future
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime departureDate;

	@NotNull
	@NotEmpty
	private String departureAirportName;
	
	@NotNull
	@NotEmpty
	private String arrivalAirportName;

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

	public Double getChildDiscount() {
		return childDiscount;
	}

	public void setChildDiscount(Double childDiscount) {
		this.childDiscount = childDiscount;
	}

	public String getDestinationCityName() {
		return destinationCityName;
	}

	public void setDestinationCityName(String destinationCityName) {
		this.destinationCityName = destinationCityName;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
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

	public String getDepartureAirportName() {
		return departureAirportName;
	}

	public void setDepartureAirportName(String departureAirportName) {
		this.departureAirportName = departureAirportName;
	}

	public String getArrivalAirportName() {
		return arrivalAirportName;
	}

	public void setArrivalAirportName(String arrivalAirportName) {
		this.arrivalAirportName = arrivalAirportName;
	}

	public Flight update(Long flightId, FlightRepository flightRepository,
			AirportRepository airportRepository, LocalRepository localRepository) {
		
		Flight flight = flightRepository.getOne(flightId); 
		Airport departureAirport = airportRepository.findByNameContaining(this.departureAirportName);
		Airport arrivalAirport = airportRepository.findByNameContaining(this.arrivalAirportName);
		Local departure = localRepository.findByCity(this.departureCityName);
		Local destination = localRepository.findByCity(this.destinationCityName);
		
		flight.setNumber(this.number);
		flight.setArrivalDate(this.arrivalDate);
		flight.setAvailableSeats(this.availableSeats);
		flight.setDepartureDate(this.departureDate);
		flight.setDuration(this.duration);
		flight.setDeparture(departure);
		flight.setDestination(destination);
		flight.setArrivalAirport(arrivalAirport);
		flight.setDepartureAirport(departureAirport);
		
		return flight;
	}

}
