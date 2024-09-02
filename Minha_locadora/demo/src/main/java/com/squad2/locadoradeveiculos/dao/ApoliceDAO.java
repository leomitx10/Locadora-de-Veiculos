package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.ApoliceSeguro;

public interface ApoliceDAO {
    List<ApoliceSeguro> get();

    ApoliceSeguro get(Long id);

    void save(ApoliceSeguro apolice);

    void delete(Long id);
}
