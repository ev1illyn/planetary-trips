package com.spacex.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airport {

	@Id
	private Long id;

	private String name;
	
	private Local address;
	
}
