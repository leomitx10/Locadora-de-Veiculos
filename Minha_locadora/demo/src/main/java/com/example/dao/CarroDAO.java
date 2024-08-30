package com.example.dao;

import java.util.List;

import com.example.demo.Carro;

public interface CarroDAO {
    
    List<Carro> get();
    
    Carro get(Long id);
    
    void save(Carro carro);
    
    void delete(Long id); 
    
}
