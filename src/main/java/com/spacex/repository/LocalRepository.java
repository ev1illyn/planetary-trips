package com.spacex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{

	Local findByCity(String cityName);
	
	Local findByCityContaining(String cityName);
	
	Page<Local> findByCity(String cityName, Pageable pagination);
	
}

