package com.wl.breakfast.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wl.breakfast.dto.BreakfastDTO;
import com.wl.breakfast.services.BreakfastService;

@RestController
@RequestMapping(value = "/breakfasts")
public class BreakfastController {
	
	@Autowired
	private BreakfastService service;
	
	@GetMapping
	public ResponseEntity<List<BreakfastDTO>> findAll(){
		List<BreakfastDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
}
