package com.spacex.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Client;
import com.spacex.model.Local;
import com.spacex.repository.LocalRepository;

public class ClientForm {

	@Length(min = 10, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 20)
	private String phoneNumber;

	@NotNull
	@NotEmpty
	private String address;
	
	@NotNull
	@NotEmpty
	private String cityName;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client convert(LocalRepository localRepository) {
		Local local = localRepository.findByCityName(cityName);
		return new Client(name, phoneNumber, local, address, email);		
	}

}