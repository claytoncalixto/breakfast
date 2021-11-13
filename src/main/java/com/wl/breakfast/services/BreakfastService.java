package com.wl.breakfast.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wl.breakfast.dto.BreakfastDTO;
import com.wl.breakfast.entities.Breakfast;
import com.wl.breakfast.repositories.BreakfastRepository;

@Service
public class BreakfastService {

	@Autowired
	private BreakfastRepository repository;
		
	@Transactional(readOnly = true)
	public List<BreakfastDTO> findAll(){
		List<Breakfast> result = repository.findAll();
		return result.stream().map(x -> new BreakfastDTO(x)).collect(Collectors.toList());
	}	

	@Transactional(readOnly = true)
	public BreakfastDTO findById(Long id) throws Exception {
		Optional<Breakfast> obj = repository.findById(id);
		Breakfast entity = obj.orElseThrow(() -> new Exception("Entity not found"));
		return new BreakfastDTO(entity);
	}

	@Transactional
	public BreakfastDTO insert(BreakfastDTO dto) {
		Breakfast entity = new Breakfast();
		entity = repository.save(entity);
		return new BreakfastDTO(entity);
	}

	@Transactional
	public BreakfastDTO update(Long id, BreakfastDTO dto) throws Exception {
		try {
		Breakfast entity =  repository.getOne(id);
		entity = repository.save(entity);
		return new BreakfastDTO(entity);
		} catch (EntityNotFoundException e){
			throw new Exception("Id not found " + id);
		}
	}

	public void  delete(Long id) throws Exception {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e ) {
			throw new Exception("Id not found "  + id);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Integraty Violation");
		}
	}
}
