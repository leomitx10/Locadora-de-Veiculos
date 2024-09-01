package com.example.service;

import java.util.List;

import com.example.dto.ApoliceSeguroDTO;

public interface ApoliceService {
    List<ApoliceSeguroDTO> get();
    
    ApoliceSeguroDTO get(int id);
    
    void save(ApoliceSeguroDTO ApoliceSeguroDTO);
    
    void delete(int id);
}
