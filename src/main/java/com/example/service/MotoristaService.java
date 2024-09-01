package com.example.service;

import java.util.List;

import com.example.dto.MotoristaDTO;

public interface MotoristaService {
    List<MotoristaDTO> get();
    
    MotoristaDTO get(int id);
    
    void save(MotoristaDTO motoristaDTO);
    
    void delete(int id);

    List<MotoristaDTO> getMotoristasByUserId(Long userId); 
}
