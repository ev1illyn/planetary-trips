package com.spacex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spacex.model.Airport;
import com.spacex.model.Local;

public class AirportDto {
	
	private Long id;

	private String name;
	
	private Local address;

	public AirportDto(Airport airport) {
		super();
		this.id = airport.getId();
		this.name = airport.getName();
		this.address = airport.getAddress();
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
	
	public static List<AirportDto> convertList(List<Airport> airports) {
		return airports.stream().map(AirportDto::new).collect(Collectors.toList());
	}
}
