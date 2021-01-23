package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Airport;
import com.spacex.model.Local;
import com.spacex.repository.LocalRepository;

public class AirportForm {

	@Length(min = 10, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	private String cityName;

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

	public Airport convert(LocalRepository localRepository) {
		Local address = localRepository.findByCityName(cityName);
		return new Airport(name, address);
	}
	
}
