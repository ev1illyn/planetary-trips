package com.spacex.controller.dto;

import org.springframework.data.domain.Page;

import com.spacex.model.User;

public class UserDto {

	private Long id;
	
	private String name;
	
	private String email;
	
	private String password;

	public UserDto(User user) {
		super();
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPass();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Page<UserDto> convertList(Page<User> users) {
		return users.map(UserDto::new);
	}
}
