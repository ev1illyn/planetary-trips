package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.Local;

public class LocalDto {

	private Long id;
	
	private String zipCode;

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

	public static Page<LocalDto> convertList(Page<Local> locals) {
		return locals.map(LocalDto::new);
	}
}
