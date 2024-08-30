package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.MotoristaDAO;
import com.example.demo.Motorista;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    @Autowired
    private MotoristaDAO motoristaDAO;

    @Override
    public List<Motorista> get() {
        return motoristaDAO.get();
    }

    @Override
    public Motorista get(int id) {
        return motoristaDAO.get(id);
    }

    @Override
    public void save(Motorista motorista) {
        motoristaDAO.save(motorista);
    }

    @Override
    public void delete(int id) {
        motoristaDAO.delete(id);
    }

    @Override
    public List<Motorista> getMotoristasByUserId(Long userId) {
        return motoristaDAO.findByUserId(userId);
    }
}