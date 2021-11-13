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
import org.springframework.web.bind.annotation.RequestBody;

import com.wl.breakfast.dto.UserDTO;
import com.wl.breakfast.entities.User;
import com.wl.breakfast.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> result = repository.findAll();
		return result.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	public UserDTO findById(Long id) throws Exception{
		Optional<User> result = repository.findById(id);
		User entity = result.orElseThrow(() -> new Exception("Usuário não encontrado!!!"));
		return new UserDTO(entity);
		
	}
	
	@Transactional
	public UserDTO insert( @RequestBody UserDTO dto) {
		User entity = new User();
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	@Transactional
	public UserDTO update(Long id, UserDTO dto) throws Exception {
		try {
		User entity =  repository.getOne(id);
		entity = repository.save(entity);
		return new UserDTO(entity);
		} catch (EntityNotFoundException e){
			throw new EntityNotFoundException("Id not found " + id);
		}
	}

	public void  delete(Long id) throws Exception {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e ) {
			throw new EmptyResultDataAccessException("Id not found "  + id, 0, e);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Integraty Violation");
		}
	}
	
}
