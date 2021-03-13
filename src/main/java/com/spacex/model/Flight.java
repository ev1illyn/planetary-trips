package com.spacex.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long number;

	private int availableSeats;

	private LocalTime duration;
	
	private Double childDiscount = 5.0;
	
	@OneToOne
	private Local destination;

	@OneToOne
	private Local departure;

	private LocalDateTime arrivalDate;

	private LocalDateTime departureDate;

	@ManyToOne
	private Airport departureAirport;
	
	@ManyToOne
	private Airport arrivalAirport;

	public Flight() {

	}
	
	public Flight(int availableSeats, LocalTime duration, Double childDiscount, Local destination, Local departure,
			LocalDateTime arrivalDate, LocalDateTime departureDate, Airport departureAirport, Airport arrivalAirport) {
		super();
		this.availableSeats = availableSeats;
		this.duration = duration;
		this.childDiscount = childDiscount;
		this.destination = destination;
		this.departure = departure;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.departureAirport = departureAirport;
		this.arrivalAirport = arrivalAirport;
	}

	public Double getChildDiscount() {
		return childDiscount;
	}

	public void setChildDiscount(Double childDiscount) {
		this.childDiscount = childDiscount;
	}
	
	public Airport getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}

	public Airport getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arrivalAirport == null) ? 0 : arrivalAirport.hashCode());
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + availableSeats;
		result = prime * result + ((childDiscount == null) ? 0 : childDiscount.hashCode());
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
		result = prime * result + ((departureAirport == null) ? 0 : departureAirport.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (arrivalAirport == null) {
			if (other.arrivalAirport != null)
				return false;
		} else if (!arrivalAirport.equals(other.arrivalAirport))
			return false;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (availableSeats != other.availableSeats)
			return false;
		if (childDiscount == null) {
			if (other.childDiscount != null)
				return false;
		} else if (!childDiscount.equals(other.childDiscount))
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		if (departureAirport == null) {
			if (other.departureAirport != null)
				return false;
		} else if (!departureAirport.equals(other.departureAirport))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}


}
