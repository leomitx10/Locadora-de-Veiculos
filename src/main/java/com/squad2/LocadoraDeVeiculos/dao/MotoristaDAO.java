package com.squad2.LocadoraDeVeiculos.dao;


public interface MotoristaDAO {
    List<Motorista> get();
    Motorista get(int id);
    void save(Motorista motorista);
    void delete(int id);
    List<Motorista> findByUserId(Long userId);
}