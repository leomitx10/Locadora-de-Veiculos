package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.CarrinhoDAO;
import com.example.demo.Carrinho;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoDAO carrinhoDAO;

    @Transactional
    @Override
    public List<Carrinho> getAll() {
        return carrinhoDAO.getAll();
    }

    @Transactional
    @Override
    public Carrinho getById(Long id) {
        return carrinhoDAO.getById(id);
    }

    @Transactional
    @Override
    public void save(Carrinho carrinho) {
        carrinhoDAO.save(carrinho);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        carrinhoDAO.delete(id);
    }
}
