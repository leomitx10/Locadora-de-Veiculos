package com.example.service;

import java.util.List;
import com.example.demo.Aluguel;

public interface AluguelService {
    List<Aluguel> get();
    
    Aluguel get(int id);
    
    void save(Aluguel aluguel);
    
    void delete(int id);
    
    List<Aluguel> getByUserId(Long userId); 
    
    void reservarCarroDoAluguel(int aluguelId);
}
