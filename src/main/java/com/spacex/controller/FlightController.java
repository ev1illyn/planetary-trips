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

import com.spacex.controller.dto.FlightDto;
import com.spacex.controller.form.FlightForm;
import com.spacex.controller.form.FlightUpdateForm;
import com.spacex.model.Flight;
import com.spacex.repository.AirportRepository;
import com.spacex.repository.FlightRepository;
import com.spacex.repository.LocalRepository;

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	AirportRepository airportRepository;

	@GetMapping
	@Cacheable(value = "flightsList")
	public Page<FlightDto> list(@RequestParam(required = false) Long flightNumber,
			@PageableDefault(sort = "number", direction = Direction.ASC, page = 0, size = 10) Pageable pagination) {

		Page<Flight> flights = flightNumber == null ? flightRepository.findAll(pagination)
				: flightRepository.findByNumber(flightNumber, pagination);

		return FlightDto.convertList(flights);
	}

	@GetMapping("/{flightId}")
	public ResponseEntity<FlightDto> details(@PathVariable Long flightId) {

		Optional<Flight> flight = flightRepository.findById(flightId);

		if (flight.isPresent()) {
			return ResponseEntity.ok(new FlightDto(flight.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@CacheEvict(value = "flightsList", allEntries = true)
	public ResponseEntity<FlightDto> add(@RequestBody FlightForm flightForm,
			UriComponentsBuilder uriBuilder) {

		Flight flight = flightForm.convert(airportRepository, localRepository);

		flightRepository.save(flight);

		URI uri = uriBuilder.path("/flights/{id}").buildAndExpand(flight.getId()).toUri();

		return ResponseEntity.created(uri).body(new FlightDto(flight));

	}

	@PutMapping("/{flightId}")
	@Transactional
	@CacheEvict(value = "flightsList", allEntries = true)
	public ResponseEntity<FlightDto> update(@PathVariable Long flightId,
			@RequestBody @Valid FlightUpdateForm flightUpdateForm) {

		Optional<Flight> optional = flightRepository.findById(flightId);

		if (optional.isPresent()) {
			Flight flight = flightUpdateForm.update(flightId, flightRepository, airportRepository, localRepository);
			return ResponseEntity.ok(new FlightDto(flight));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{flightId}")
	@CacheEvict(value = "flightsList", allEntries = true)
	public ResponseEntity<FlightDto> delete(@PathVariable Long flightId) {

		Optional<Flight> flight = flightRepository.findById(flightId);

		if (flight.isPresent()) {
			flightRepository.deleteById(flightId);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}
}
