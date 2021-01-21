package com.spacex.model;

import javax.persistence.Entity;

@Entity
public enum Status {
	
	CANCELLED,
	NOT_ACTIVE,
	ACTIVE,
	LANDED,
	FINISHED
	
}
