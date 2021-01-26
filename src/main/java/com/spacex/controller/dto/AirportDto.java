package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.Airport;
import com.spacex.model.Local;

public class AirportDto {
	
	private Long id;

	private String name;
	
	private Local address;
	
	private String street;

	public AirportDto(Airport airport) {
		super();
		this.id = airport.getId();
		this.name = airport.getName();
		this.address = airport.getAddress();
		this.street = airport.getStreet();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Local getAddress() {
		return address;
	}

	public void setAddress(Local address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public static Page<AirportDto> convertList(Page<Airport> airports) {
		return airports.map(AirportDto::new);
	}
	
}
