package com.example.dao;

import java.util.List;

import com.example.model.Aluguel;

public interface AluguelDAO {
    List<Aluguel> get();
    
    Aluguel get(int id);
    
    void save(Aluguel aluguel);
    
    void delete(int id);
    
    List<Aluguel> getByUserId(Long userId);
}
