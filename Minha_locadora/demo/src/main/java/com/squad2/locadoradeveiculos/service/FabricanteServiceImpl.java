package com.squad2.locadoradeveiculos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad2.locadoradeveiculos.dao.FabricanteDAO;
import com.squad2.locadoradeveiculos.model.Fabricante;

@Service
public class FabricanteServiceImpl implements FabricanteService {
    
    @Autowired
    private FabricanteDAO fabricanteDAO;

    @Override
    public List<Fabricante> get() {
        return fabricanteDAO.findAll();
    }

    @Override
    public Fabricante get(Long id) {
        return fabricanteDAO.findById(id).orElse(null);
    }

    @Override
    public void save(Fabricante fabricante) {
        fabricanteDAO.save(fabricante);
    }

    @Override
    public void delete(Long id) {
        fabricanteDAO.deleteById(id);
    }

    @Override
    public List<Fabricante> getFabricantesByUserId(Long userId) {
        // You would need to implement this method in the DAO if needed
        return null;
    }
}
