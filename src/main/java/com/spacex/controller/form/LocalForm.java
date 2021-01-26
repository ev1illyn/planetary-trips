package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Local;

public class LocalForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 25)
	private String zipCode;

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	private String country;

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 255)
	private String state;

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	private String city;

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public Local converter() {
		return new Local(zipCode, country, state, city);
	}
	
}
