package com.example.service;

import java.util.List;

import com.example.dto.CarroDTO;

public interface CarroService {
	
	List<CarroDTO> get();
	
	CarroDTO get(int id);
	
	void save(CarroDTO carroDTO);
	
	void delete(int id); 
	
}
