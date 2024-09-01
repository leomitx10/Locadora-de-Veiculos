package com.example.service;

import java.util.List;

import com.example.demo.Carro;
import com.example.demo.Categoria;

public interface CarroService {
	
	List<Carro> get();
	
	Carro get(Long id);
	
	void save(Carro carro);
	
	void delete(Long id); 
	
	List<Carro> getByCategoria(Categoria categoria);
	
	List<Carro> getByAcessorio(String acessorio);
	
	void reservarCarro(Long id);
}