package com.spacex.controller.dto;

import java.time.LocalDateTime;

import com.spacex.model.Payment;

public class PaymentDto {

	private Long id;
	
	private Double value;
	
	private LocalDateTime date;

	public PaymentDto(Payment payment) {
		super();
		this.id = payment.getId();
		this.value = payment.getValue();
		this.date = payment.getDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
	
}
