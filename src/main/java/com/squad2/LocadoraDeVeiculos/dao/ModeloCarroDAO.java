package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;

public interface ModeloCarroDAO {
    void save(ModeloCarro modeloCarro);
    List<ModeloCarro> getAll();
    ModeloCarro getById(Long id);
    void update(ModeloCarro modeloCarro);
    void delete(Long id);
}