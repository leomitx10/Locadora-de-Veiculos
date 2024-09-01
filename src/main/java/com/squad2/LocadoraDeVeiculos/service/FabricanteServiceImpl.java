package com.squad2.LocadoraDeVeiculos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.FabricanteDAO;
import com.example.demo.Fabricante;

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
        return null;
    }
}