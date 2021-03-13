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

import com.spacex.controller.dto.LocalDto;
import com.spacex.controller.form.LocalForm;
import com.spacex.controller.form.LocalUpdateForm;
import com.spacex.model.Local;
import com.spacex.repository.LocalRepository;

@RestController
@RequestMapping("/locals")
public class LocalController {

	@Autowired
	private LocalRepository localRepository;

	@GetMapping
	@Cacheable(value = "localsList")
	public Page<LocalDto> list(@RequestParam(required = false) String cityName,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		Page<Local> locals = cityName == null ? localRepository.findAll(pagination)
				: localRepository.findByCity(cityName, pagination);

		return LocalDto.convertList(locals);
	}

	@GetMapping("/{localId}")
	public ResponseEntity<LocalDto> details(@PathVariable Long localId) {

		Optional<Local> local = localRepository.findById(localId);

		if (local.isPresent()) {
			return ResponseEntity.ok(new LocalDto(local.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value = "localsList", allEntries = true)
	public ResponseEntity<LocalDto> add(@RequestBody @Valid LocalForm localForm,
			UriComponentsBuilder uriBuilder) {

		Local local = localForm.convert();

		localRepository.save(local);

		URI uri = uriBuilder.path("/locals/{id}").buildAndExpand(local.getId()).toUri();

		return ResponseEntity.created(uri).body(new LocalDto(local));

	}

	@PutMapping("/{localId}")
	@Transactional
	@CacheEvict(value = "localsList", allEntries = true)
	public ResponseEntity<LocalDto> update(@PathVariable Long localId,
			@RequestBody @Valid LocalUpdateForm localUpdateForm) {

		Optional<Local> optional = localRepository.findById(localId);

		if (optional.isPresent()) {
			Local local = localUpdateForm.update(localId, localRepository);
			return ResponseEntity.ok(new LocalDto(local));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{localId}")
	@CacheEvict(value = "localsList", allEntries = true)
	public ResponseEntity<LocalDto> delete(@PathVariable Long localId){

			Optional<Local> local = localRepository.findById(localId);

			if (local.isPresent()) {
				localRepository.deleteById(localId);
				return ResponseEntity.ok().build();
			}
			
			return ResponseEntity.notFound().build();		
	}

}