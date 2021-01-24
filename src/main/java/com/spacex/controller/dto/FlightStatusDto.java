package com.spacex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<FlightStatusDto> convertList(List<FlightStatus> flightStatus) {
		return flightStatus.stream().map(FlightStatusDto::new).collect(Collectors.toList());
	}
}
