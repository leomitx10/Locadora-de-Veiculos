package com.example.dao;

import java.util.List;
import com.example.demo.ModeloCarro;

public interface ModeloCarroDAO {
    void save(ModeloCarro modeloCarro);
    List<ModeloCarro> getAll();
    ModeloCarro getById(Long id);
    void update(ModeloCarro modeloCarro);
    void delete(Long id);
}
