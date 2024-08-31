package com.example.service;

import java.util.List;
import com.example.demo.Motorista;

public interface MotoristaService {
    List<Motorista> get();
    
    Motorista get(int id);
    
    void save(Motorista motorista);
    
    void delete(int id);

    List<Motorista> getMotoristasByUserId(Long userId); 
}