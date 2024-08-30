package com.example.dao;

import com.example.demo.Fabricante;

import java.util.List;
import java.util.Optional;

public interface FabricanteDAO {
    Fabricante save(Fabricante fabricante);
    Optional<Fabricante> findById(Long id);
    List<Fabricante> findAll();
    void deleteById(Long id);
}
