package com.wl.breakfast.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wl.breakfast.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
}
