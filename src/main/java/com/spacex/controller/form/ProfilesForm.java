package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Profiles;

public class ProfilesForm {

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 20)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Profiles converter() {
		return new Profiles(name);		
	}
	
}
