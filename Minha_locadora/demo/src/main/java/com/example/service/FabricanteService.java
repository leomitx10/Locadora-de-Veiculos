package com.example.service;

import java.util.List;
import com.example.demo.Fabricante;

public interface FabricanteService {
    List<Fabricante> get();
    
    Fabricante get(Long id);
    
    void save(Fabricante fabricante);
    
    void delete(Long id);

    List<Fabricante> getFabricantesByUserId(Long userId);
}
