package com.squad2.locadoradeveiculos.service;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Motorista;

public interface MotoristaService {
    List<Motorista> get();
    
    Motorista get(int id);
    
    void save(Motorista motorista);
    
    void delete(int id);

    List<Motorista> getMotoristasByUserId(Long userId); 
}