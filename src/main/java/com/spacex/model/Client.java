package com.spacex.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

	@Id
	private Long id;
	
	private String name;
	
	private String phoneNumber;
	
	private Local local;
	
	private String address;
	
	private String email;
	
}
