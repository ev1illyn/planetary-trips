package com.spacex.controller.dto;

import com.spacex.model.Local;

public class LocalDto {

	private Long id;
	
	private Long zipCode;

	private String country;
	
	private String state;
	
	private String city;

	public LocalDto(Local local) {
		super();
		this.id = local.getId();
		this.zipCode = local.getZipCode();
		this.country = local.getCountry();
		this.state = local.getState();
		this.city = local.getCity();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getZipCode() {
		return zipCode;
	}

	public void setZipCode(Long zipCode) {
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
	
}
