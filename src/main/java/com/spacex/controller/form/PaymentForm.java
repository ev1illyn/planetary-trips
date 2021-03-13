package com.spacex.controller.form;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.Payment;

public class PaymentForm {

	@NotNull
	@Length(max = 100000)
	private Double value;

	@NotNull
	private LocalDateTime date;

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Payment convert() {
		return new Payment(value, date);		
	}
	
}
