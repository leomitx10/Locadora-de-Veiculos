package com.example.dao;

import java.util.List;
import com.example.demo.Motorista;

public interface MotoristaDAO {
    List<Motorista> get();
    Motorista get(int id);
    void save(Motorista motorista);
    void delete(int id);
    List<Motorista> findByUserId(Long userId); 
}
