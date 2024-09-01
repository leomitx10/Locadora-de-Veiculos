package com.example.dao;

import java.util.List;

import com.example.model.ApoliceSeguro;

public interface ApoliceDAO {
    List<ApoliceSeguro> get();
    
    ApoliceSeguro get(int id);
    
    void save(ApoliceSeguro apolice);
    
    void delete(int id); 
}
