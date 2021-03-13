package com.spacex.controller.form;

import java.time.LocalDateTime;
import java.util.HashMap;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Flight;
import com.spacex.model.FlightBooking;
import com.spacex.model.Passenger;
import com.spacex.model.User;
import com.spacex.repository.FlightRepository;
import com.spacex.repository.UserRepository;

public class FlightBookingForm {
	
	@NotNull
	@Length(min = 50, max = 10000)
	private Double price;
	
	@NotNull
	private Long flightNumber;

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 255)
	private String userName;

	@NotNull
	private LocalDateTime bookingDate;

	@NotNull
	private HashMap<Passenger, Double> passengers;

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public FlightBooking convert(FlightRepository flightRepository,
			UserRepository userRepository) {
		Flight flight = flightRepository.findByNumber(flightNumber);
		User user = userRepository.findByNameContaining(userName);
		// passengers
		return new FlightBooking(flight.getId(), passengers, price, flight, user, bookingDate);
	}
	
}
