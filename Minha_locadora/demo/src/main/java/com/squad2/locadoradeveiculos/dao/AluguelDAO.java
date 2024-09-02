package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Aluguel;

public interface AluguelDAO {
    List<Aluguel> get();
    
    Aluguel get(int id);
    
    void save(Aluguel aluguel);
    
    void delete(int id);
    
    List<Aluguel> getByUserId(Long userId);  
}
