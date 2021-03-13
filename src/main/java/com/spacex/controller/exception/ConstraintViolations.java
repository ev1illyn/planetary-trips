package com.spacex.controller.exception;

public class ConstraintViolations {

	private String field;
	
	private String error;

	public String getField() {
		return field;
	}

	public String getError() {
		return error;
	}

	public ConstraintViolations(String field, String error) {
		super();
		this.field = field;
		this.error = error;
	}
	
}
