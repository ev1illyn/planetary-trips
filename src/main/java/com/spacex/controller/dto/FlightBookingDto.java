package com.spacex.controller.dto;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.data.domain.Page;

import com.spacex.model.Flight;
import com.spacex.model.FlightBooking;
import com.spacex.model.Passenger;
import com.spacex.model.User;

public class FlightBookingDto {

	private Long id;

	private Boolean childDiscount;
	
	private HashMap<Passenger, Double> passengers;

	private Double price;
	
	private Flight flight;
	
	private User user;
	
	private LocalDateTime bookingDate = LocalDateTime.now();

	public FlightBookingDto(FlightBooking flightBooking) {
		super();
		this.id = flightBooking.getId();
		this.passengers = flightBooking.getPassengers();
		this.price = flightBooking.getPrice();
		this.flight = flightBooking.getFlight();
		this.user = flightBooking.getUser();
		this.bookingDate = flightBooking.getBookingDate();
	}

	public HashMap<Passenger, Double> getPassengers() {
		return passengers;
	}

	public void setPassengers(HashMap<Passenger, Double> passengers) {
		this.passengers = passengers;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Boolean getChildDiscount() {
		return childDiscount;
	}

	public void setChildDiscount(Boolean childDiscount) {
		this.childDiscount = childDiscount;
	}

	public static Page<FlightBookingDto> convertList(Page<FlightBooking> flights) {
		return flights.map(FlightBookingDto::new);
	}
	
}
