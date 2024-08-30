package com.example.service;


import com.example.dao.FabricanteDAO;
import com.example.demo.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteDAO fabricanteDAO;

    public Fabricante save(Fabricante fabricante) {
        return fabricanteDAO.save(fabricante);
    }

    public Optional<Fabricante> findById(Long id) {
        return fabricanteDAO.findById(id);
    }

    public List<Fabricante> findAll() {
        return fabricanteDAO.findAll();
    }

    public void deleteById(Long id) {
        fabricanteDAO.deleteById(id);
    }
}
