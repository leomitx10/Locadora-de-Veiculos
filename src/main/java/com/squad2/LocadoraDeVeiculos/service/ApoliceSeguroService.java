package com.squad2.LocadoraDeVeiculos.service;

public interface ApoliceService {

    List<ApoliceSeguro> get();

    ApoliceSeguro get(Long id);

    void save(ApoliceSeguro apolice);

    void delete(Long id);
}