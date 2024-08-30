package com.example.service;

import java.util.List;

import com.example.demo.Carro;

public interface CarroService {
	
	List<Carro> get();
	
	Carro get(Long id);
	
	void save(Carro carro);
	
	void delete(Long id); 
	
}