package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Airport;
import com.spacex.model.Local;
import com.spacex.repository.LocalRepository;

public class AirportForm {

	@NotNull
	@NotEmpty
	@Length(min = 10, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String cityName;

	@NotNull
	@NotEmpty
	@Length(min = 10, max = 255)
	private String street;

	@NotNull
	private Double childDiscount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Airport convert(LocalRepository localRepository) {
		Local address = localRepository.findByCity(cityName);
		return new Airport(name, address, street, childDiscount);
	}
	
}
