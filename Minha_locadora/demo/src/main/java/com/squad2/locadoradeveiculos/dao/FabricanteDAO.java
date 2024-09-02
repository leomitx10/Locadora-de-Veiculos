package com.squad2.locadoradeveiculos.dao;

import java.util.List;
import java.util.Optional;

import com.squad2.locadoradeveiculos.model.Fabricante;

public interface FabricanteDAO {
    Fabricante save(Fabricante fabricante);
    Optional<Fabricante> findById(Long id);
    List<Fabricante> findAll();
    void deleteById(Long id);
}
