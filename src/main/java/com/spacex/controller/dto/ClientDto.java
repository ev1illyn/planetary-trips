package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.Client;
import com.spacex.model.Local;

public class ClientDto {

	private Long id;
	
	private String name;
	
	private String phoneNumber;

	private Local local;

	private String address;
	
	private String email;

	public ClientDto(Client client) {
		super();
		this.id = client.getId();
		this.name = client.getName();
		this.phoneNumber = client.getPhoneNumber();
		this.local = client.getLocal();
		this.address = client.getAddress();
		this.email = client.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Page<ClientDto> convertList(Page<Client> clients) {
		return clients.map(ClientDto::new);
	}
}
