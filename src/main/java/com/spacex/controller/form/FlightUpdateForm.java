package com.spacex.controller.form;

import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Airport;
import com.spacex.model.Flight;
import com.spacex.model.Local;
import com.spacex.repository.AirportRepository;
import com.spacex.repository.FlightRepository;
import com.spacex.repository.LocalRepository;

public class FlightUpdateForm {

	@NotNull
	@Length(min = 1, max = 10)
	private int availableSeats;

	@NotNull
	private LocalTime duration;
	
	@NotNull
	private Double childDiscount;
	
	@NotNull
	@NotEmpty
	private String destinationCityName;

	@NotNull
	@NotEmpty
	private String departureCityName;

	@NotNull
	private LocalDateTime arrivalDate;

	@NotNull
	private LocalDateTime departureDate;

	@NotNull
	@NotEmpty
	private String departureAirportName;
	
	@NotNull
	@NotEmpty
	private String arrivalAirportName;

	public Flight update(Long flightId, FlightRepository flightRepository,
			AirportRepository airportRepository, LocalRepository localRepository) {
		
		Flight flight = flightRepository.getOne(flightId); 
		Airport departureAirport = airportRepository.findByNameContaining(this.departureAirportName);
		Airport arrivalAirport = airportRepository.findByNameContaining(this.arrivalAirportName);
		Local departure = localRepository.findByCity(this.departureCityName);
		Local destination = localRepository.findByCity(this.destinationCityName);
		
		flight.setNumber(flightId);
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
