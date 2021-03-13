package com.spacex.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.User;
import com.spacex.model.Local;
import com.spacex.repository.UserRepository;
import com.spacex.repository.LocalRepository;

public class UserUpdateForm {

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 10)
	private String password;

	@NotNull
	@NotEmpty
	@Length(min = 8, max = 20)
	private String phoneNumber;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String cityName;

	@NotNull
	@NotEmpty
	@Length(min = 10, max = 255)
	private String street;

	//@NotNull
	//@NotEmpty
	//@Length(min = 3, max = 20)
	private List<String> profileName = new ArrayList<>();

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public List<String> getProfileName() {
		return profileName;
	}

	public void setProfileName(List<String> profileName) {
		this.profileName = profileName;
	}
	
	public User update(Long id, UserRepository userRepository, LocalRepository localRepository) {
		User user = userRepository.getOne(id);
		Local local = localRepository.findByCity(this.cityName);
		
		user.setName(this.name);
		user.setEmail(this.email);
		user.setPass(this.password);
		user.setPhoneNumber(this.phoneNumber);
		user.setLocal(local);
		user.setStreet(this.street);
		
		return user;
	}
}
