package com.example.service;

import java.util.List;

import com.example.dto.AluguelDTO;

public interface AluguelService {
    List<AluguelDTO> get();
    
    AluguelDTO get(int id);
    
    void save(AluguelDTO aluguelDTO);
    
    void delete(int id);
    
    List<AluguelDTO> getByUserId(Long userId); 
}
