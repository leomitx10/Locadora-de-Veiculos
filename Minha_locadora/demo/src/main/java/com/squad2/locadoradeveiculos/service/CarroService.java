package com.squad2.locadoradeveiculos.service;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Carro;
import com.squad2.locadoradeveiculos.model.Categoria;

public interface CarroService {
	
	List<Carro> get();
	
	Carro get(Long id);
	
	void save(Carro carro);
	
	void delete(Long id); 
	
	List<Carro> getByCategoria(Categoria categoria);
	
	List<Carro> getByAcessorio(String acessorio);
	
	void reservarCarro(Long id);
}