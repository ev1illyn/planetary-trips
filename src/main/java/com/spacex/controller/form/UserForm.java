package com.spacex.controller.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.User;

import com.spacex.model.Local;
import com.spacex.model.Profiles;
import com.spacex.repository.ProfilesRepository;

public class UserForm {

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 255)
	private String name;

	@NotNull
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@NotEmpty
	@Length(min = 5, max = 10)
	private String password;

	@NotNull
	@NotEmpty
	@Length(min = 3, max = 20)
	private List<String> profileName = new ArrayList<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getProfileName() {
		return profileName;
	}

	public void setProfileName(List<String> profileName) {
		this.profileName = profileName;
	}

	public User converter(ProfilesRepository profilesRepository) {
		List<Profiles> profiles = profilesRepository.findByProfileContaining(profileName);
		return new User(name, email, password, profiles);	
	}
	
}
