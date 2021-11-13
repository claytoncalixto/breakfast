package com.wl.breakfast.dto;

import java.io.Serializable;

import com.wl.breakfast.entities.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String cpf;
	
	public UserDTO() {
	}

	public UserDTO(Long id, String name,  String cpf) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
	}
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
