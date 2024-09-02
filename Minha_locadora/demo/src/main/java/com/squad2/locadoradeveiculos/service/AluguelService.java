package com.squad2.locadoradeveiculos.service;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Aluguel;

public interface AluguelService {
    List<Aluguel> get();
    
    Aluguel get(int id);
    
    void save(Aluguel aluguel);
    
    void delete(int id);
    
    List<Aluguel> getByUserId(Long userId); 

    List<Aluguel> getByMotoristaId(Integer motoristaId);
    
    void reservarCarroDoAluguel(int aluguelId);
}
