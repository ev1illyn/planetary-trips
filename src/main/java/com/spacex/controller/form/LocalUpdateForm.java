package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Local;
import com.spacex.repository.LocalRepository;

public class LocalUpdateForm {

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String zipCode;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String country;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String state;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 255)
	private String city;

	public Local update(Long id, LocalRepository localRepository) {
		
		Local local = localRepository.getOne(id);
		local.setZipCode(this.zipCode);
		local.setCountry(this.country);
		local.setState(this.state);
		local.setCity(this.city);
		
		return local;
	}
	
}
