package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Motorista;

public interface MotoristaDAO {
    List<Motorista> get();
    Motorista get(int id);
    void save(Motorista motorista);
    void delete(int id);
    List<Motorista> findByUserId(Long userId); 
}
