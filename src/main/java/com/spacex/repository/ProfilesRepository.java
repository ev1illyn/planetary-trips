package com.spacex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.Profiles;

@Repository
public interface ProfilesRepository extends JpaRepository<Profiles, Long>{

	List<Profiles> findByProfileContaining(List<String> profileName);
}

