package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.ModeloCarro;

public interface ModeloCarroDAO {
    void save(ModeloCarro modeloCarro);
    List<ModeloCarro> getAll();
    ModeloCarro getById(Long id);
    void update(ModeloCarro modeloCarro);
    void delete(Long id);
}