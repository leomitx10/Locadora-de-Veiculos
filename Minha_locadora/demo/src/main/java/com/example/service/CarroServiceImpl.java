package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CarroDAO;
import com.example.demo.Carro;
import com.example.demo.Categoria;

import jakarta.transaction.Transactional;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroDAO carroDAO; 
    
    @Transactional
    @Override
    public List<Carro> get() {
        return carroDAO.get();
    }

    @Transactional
    @Override
    public Carro get(Long id) {
        return carroDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Carro carro) {
        carroDAO.save(carro);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        carroDAO.delete(id);
    }
    
    @Transactional
    @Override
    public List<Carro> getByCategoria(Categoria categoria) {
        return carroDAO.getByCategoria(categoria);
    }
    
    @Transactional
    @Override
    public List<Carro> getByAcessorio(String acessorio) {
        return carroDAO.getByAcessorio(acessorio);
    }

    @Transactional
    @Override
    public void reservarCarro(Long id) {
        Carro carro = carroDAO.get(id);
        if (carro != null) {
            carro.setReservado(true);
            carroDAO.save(carro);
        } else {
            throw new RuntimeException("Carro não encontrado com o id: " + id);
        }
    }
}
