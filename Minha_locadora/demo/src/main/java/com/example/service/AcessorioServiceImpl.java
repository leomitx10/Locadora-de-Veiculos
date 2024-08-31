package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.AcessorioDAO;
import com.example.demo.Acessorio;

@Service
public class AcessorioServiceImpl implements AcessorioService {

    @Autowired
    private AcessorioDAO acessorioDAO;

    @Override
    public List<Acessorio> get() {
        return acessorioDAO.get();
    }

    @Override
    public Acessorio get(int id) {
        return acessorioDAO.get(id);
    }

    @Override
    public void save(Acessorio acessorio) {
        acessorioDAO.save(acessorio);
    }

    @Override
    public void delete(int id) {
        acessorioDAO.delete(id);
    }
}
