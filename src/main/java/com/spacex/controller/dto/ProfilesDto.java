package com.spacex.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spacex.model.Profiles;

public class ProfilesDto {

	private Long id;
	
	private String name;

	public ProfilesDto(Profiles profiles) {
		super();
		this.id = profiles.getId();
		this.name = profiles.getName();
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

	public static List<ProfilesDto> convertList(List<Profiles> profiles) {
		return profiles.stream().map(ProfilesDto::new).collect(Collectors.toList());
	}
}
