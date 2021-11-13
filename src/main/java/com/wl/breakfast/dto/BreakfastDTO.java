package com.wl.breakfast.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.wl.breakfast.entities.Breakfast;

public class BreakfastDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String options;
	private Integer deals;
	private Double amount;
	private LocalDate date;

	private UserDTO userDTO;
	
	public BreakfastDTO (){
	}

	public BreakfastDTO(Long id, String options, Integer deals, LocalDate date, UserDTO userDTO) {
		this.id = id;
		this.options = options;
		this.deals = deals;
		this.date = date;
		this.userDTO = userDTO;
	}
	
	public BreakfastDTO(Breakfast entity) {
		id = entity.getId();
		options = entity.getOptions();
		date = entity.getDate();
		userDTO = new UserDTO(entity.getUser());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Integer getDeals() {
		return deals;
	}

	public void setDeals(Integer deals) {
		this.deals = deals;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}	
}
