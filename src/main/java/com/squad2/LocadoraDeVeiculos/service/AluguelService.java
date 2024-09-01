package com.squad2.LocadoraDeVeiculos.service;


public interface AluguelService {
    List<Aluguel> get();

    Aluguel get(int id);

    void save(Aluguel aluguel);

    void delete(int id);

    List<Aluguel> getByUserId(Long userId);
}