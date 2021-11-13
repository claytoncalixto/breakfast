package com.wl.breakfast.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wl.breakfast.entities.Breakfast;

public interface BreakfastRepository extends JpaRepository<Breakfast, Long>{
	
   List<Breakfast> findAll();

   Optional<Breakfast> findById(Long id);

}
