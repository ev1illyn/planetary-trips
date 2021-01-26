package com.spacex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	Client findByNameContaining(String clientName);

}

