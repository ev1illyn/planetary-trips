package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.Passenger;

public class PassengerDto {

	private Long id;
	
	private String name;
	
	private String email;
	
	private Boolean isChild;

	public PassengerDto(Passenger passenger) {
		super();
		this.id = passenger.getId();
		this.name = passenger.getName();
		this.email = passenger.getEmail();
		this.isChild = passenger.getIsChild();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsChild() {
		return isChild;
	}

	public void setIsChild(Boolean isChild) {
		this.isChild = isChild;
	}

	public static Page<PassengerDto> convertList(Page<Passenger> passengers) {
		return passengers.map(PassengerDto::new);
	}
	
}
