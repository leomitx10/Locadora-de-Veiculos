package com.example.dao;

import java.util.List;

import com.example.model.Carro;

public interface CarroDAO {
    
    List<Carro> get();
    
    Carro get(int id);
    
    void save(Carro carro);
    
    void delete(int id); 
    
}
