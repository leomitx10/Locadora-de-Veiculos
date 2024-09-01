package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;
import com.example.demo.ApoliceSeguro;

public interface ApoliceDAO {
    List<ApoliceSeguro> get();

    ApoliceSeguro get(Long id);

    void save(ApoliceSeguro apolice);

    void delete(Long id);
}