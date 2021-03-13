package com.spacex.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spacex.controller.dto.UserDto;
import com.spacex.controller.form.UserForm;
import com.spacex.controller.form.UserUpdateForm;
import com.spacex.model.User;
import com.spacex.repository.LocalRepository;
import com.spacex.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	@GetMapping
	@Cacheable(value = "usersList")
	public Page<UserDto> list(@RequestParam(required = false) String userName,
			@PageableDefault(sort = "name", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		Page<User> users = userName == null ? userRepository.findAll(pagination)
				: userRepository.findByNameContaining(userName, pagination);

		return UserDto.convertList(users);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> details(@PathVariable Long userId) {

		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			return ResponseEntity.ok(new UserDto(user.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value = "usersList", allEntries = true)
	public ResponseEntity<UserDto> add(@RequestBody @Valid UserForm userForm,
			UriComponentsBuilder uriBuilder) {

		User user = userForm.convert(localRepository);

		userRepository.save(user);

		URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

		return ResponseEntity.created(uri).body(new UserDto(user));

	}

	@PutMapping("/{userId}")
	@Transactional
	@CacheEvict(value = "usersList", allEntries = true)
	public ResponseEntity<UserDto> update(@PathVariable Long userId, @RequestBody @Valid UserUpdateForm userUpdateForm) {
		
		System.out.println(userUpdateForm.toString());
		
		Optional<User> optional = userRepository.findById(userId);

		if (optional.isPresent()) {
			User user = userUpdateForm.update(userId, userRepository, localRepository);
			return ResponseEntity.ok(new UserDto(user));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{userId}")
	@CacheEvict(value = "usersList", allEntries = true)
	public ResponseEntity<UserDto> delete(@PathVariable Long userId) {

		Optional<User> user = userRepository.findById(userId);

		if (user.isPresent()) {
			userRepository.deleteById(userId);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
