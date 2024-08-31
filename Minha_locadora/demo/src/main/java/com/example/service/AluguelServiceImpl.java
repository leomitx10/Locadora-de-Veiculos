package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AluguelDAO;
import com.example.demo.Aluguel;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelDAO aluguelDAO;

    @Transactional
    @Override
    public List<Aluguel> get() {
        return aluguelDAO.get();
    }

    @Transactional
    @Override
    public Aluguel get(int id) {
        return aluguelDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Aluguel aluguel) {
        aluguelDAO.save(aluguel);
    }

    @Transactional
    @Override
    public void delete(int id) {
        aluguelDAO.delete(id);
    }

    @Transactional
    @Override
    public List<Aluguel> getByUserId(Long userId) {
        return aluguelDAO.getByUserId(userId);  // Implementação do novo método
    }
}