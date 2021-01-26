package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.FlightStatus;
import com.spacex.model.Local;
import com.spacex.model.Status;

public class FlightStatusDto {

	private Long id;
	
	private Status status = Status.NOT_ACTIVE;
	
	private Local local;
	
	private String observations;

	public FlightStatusDto(FlightStatus flightStatus) {
		super();
		this.id = flightStatus.getId();
		this.status = flightStatus.getStatus();
		this.local = flightStatus.getLocal();
		this.observations = flightStatus.getObservations();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public static Page<FlightStatusDto> convertList(Page<FlightStatus> flightStatus) {
		return flightStatus.map(FlightStatusDto::new);
	}
}
