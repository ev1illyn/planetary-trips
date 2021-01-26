package com.spacex.controller.form;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Airport;
import com.spacex.model.Flight;
import com.spacex.model.Local;
import com.spacex.model.Passenger;
import com.spacex.repository.AirportRepository;
import com.spacex.repository.LocalRepository;

public class FlightForm {

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 10)
	private int availableSeats;

	@NotNull
	@NotEmpty
	@Length(max = 10000)
	private Double duration;
	
	private HashMap<Passenger, Double> priceByPassenger;

	@NotNull
	@NotEmpty
	private String destinationCityName;

	@NotNull
	@NotEmpty
	private String departureCityName;

	@NotNull
	@NotEmpty
	private LocalDateTime arrivalDate;

	@NotNull
	@NotEmpty
	private LocalDateTime departureDate;

	@NotNull
	@NotEmpty
	private String airportName;

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

	public String getDestinationCityName() {
		return destinationCityName;
	}

	public void setDestination(String destinationCityName) {
		this.destinationCityName = destinationCityName;
	}

	public String getDeparture() {
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

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	public Flight convert(AirportRepository airportRepository,
			LocalRepository localRepository) {
		Airport airport = airportRepository.findByNameContaining(airportName);
		Local departure = localRepository.findByCity(departureCityName);
		Local destination = localRepository.findByCity(destinationCityName);
		return new Flight(availableSeats, duration, priceByPassenger, destination, departure, arrivalDate, departureDate, airport);
	}
}