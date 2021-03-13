package com.spacex.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spacex.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByNameContaining(String userName);

	Page<User> findByNameContaining(String userName, Pageable pagination);
}

