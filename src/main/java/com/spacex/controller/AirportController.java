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

import com.spacex.controller.dto.AirportDto;
import com.spacex.controller.form.AirportForm;
import com.spacex.controller.form.AirportUpdateForm;
import com.spacex.model.Airport;
import com.spacex.repository.AirportRepository;
import com.spacex.repository.LocalRepository;

@RestController
@RequestMapping("/airports")
public class AirportController {

	@Autowired
	private AirportRepository airportRepository;

	@Autowired
	private LocalRepository localRepository;

	@GetMapping
	@Cacheable(value = "airportsList")
	public Page<AirportDto> list(@RequestParam(required = false) String airportName,
			@PageableDefault(sort = "id", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		Page<Airport> airports = airportName == null ? airportRepository.findAll(pagination)
				: airportRepository.findByNameContaining(airportName, pagination);

		return AirportDto.convertList(airports);
	}

	@GetMapping("/{airportId}")
	public ResponseEntity<AirportDto> details(@PathVariable Long airportId) {

		Optional<Airport> airport = airportRepository.findById(airportId);

		if (airport.isPresent()) {
			return ResponseEntity.ok(new AirportDto(airport.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value = "airportsList", allEntries = true)
	public ResponseEntity<AirportDto> cadastrar(@RequestBody @Valid AirportForm airportForm,
			UriComponentsBuilder uriBuilder) {

		Airport airport = airportForm.convert(localRepository);

		airportRepository.save(airport);

		URI uri = uriBuilder.path("/airports/{id}").buildAndExpand(airport.getId()).toUri();

		return ResponseEntity.created(uri).body(new AirportDto(airport));

	}

	@PutMapping("/{airportId}")
	@Transactional
	@CacheEvict(value = "airportsList", allEntries = true)
	public ResponseEntity<AirportDto> update(@PathVariable Long airportId, @RequestBody @Valid AirportUpdateForm airportUpdateForm) {
		
		Optional<Airport> optional = airportRepository.findById(airportId);

		if (optional.isPresent()) {
			Airport airport = airportUpdateForm.update(airportId, airportRepository, localRepository);
			return ResponseEntity.ok(new AirportDto(airport));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{airportId}")
	@CacheEvict(value = "airportsList", allEntries = true)
	public ResponseEntity<AirportDto> delete(@PathVariable Long airportId) {

		Optional<Airport> airport = airportRepository.findById(airportId);

		if (airport.isPresent()) {
			airportRepository.deleteById(airportId);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}
