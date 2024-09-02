package com.squad2.locadoradeveiculos.service;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Fabricante;

public interface FabricanteService {
    List<Fabricante> get();
    
    Fabricante get(Long id);
    
    void save(Fabricante fabricante);
    
    void delete(Long id);

    List<Fabricante> getFabricantesByUserId(Long userId);
}
