package com.spacex.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.spacex.model.FlightStatus;
import com.spacex.model.Local;
import com.spacex.model.Status;
import com.spacex.repository.LocalRepository;

public class FlightStatusForm {

	@NotNull
	private Status status = Status.NOT_ACTIVE;

	@NotNull
	@NotEmpty
	private String localStatus;

	@Length(max = 255)
	private String observations;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLocalStatus() {
		return localStatus;
	}

	public void setLocalStatus(String localStatus) {
		this.localStatus = localStatus;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public FlightStatus convert(LocalRepository localRepository) {
		Local local = localRepository.findByCity(localStatus);
		return new FlightStatus(status, local, observations);
	}
	
}
