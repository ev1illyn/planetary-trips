package com.spacex.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Local {

	@Id
	private Long id;
	
	private Long zipCode;

	private String country;
	
	private String state;
	
	private String city;
	
}
