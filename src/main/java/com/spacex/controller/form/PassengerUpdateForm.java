package com.spacex.controller.form;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.spacex.model.Passenger;
import com.spacex.repository.PassengerRepository;

public class PassengerUpdateForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotEmpty
	private String name;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	private Boolean isChild;

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
	
	public Passenger update(Long id, PassengerRepository passengerRepository) {
		
		Passenger passenger = passengerRepository.getOne(id);
		
		passenger.setEmail(this.email);
		passenger.setIsChild(this.isChild);
		passenger.setName(this.name);
		
		return passenger;
	}
}
