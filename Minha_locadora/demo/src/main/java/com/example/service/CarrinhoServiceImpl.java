package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.CarrinhoDAO;
import com.example.demo.Carrinho;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoDAO carrinhoDAO;

    @Override
    public List<Carrinho> get() {
        return carrinhoDAO.get();
    }

    @Override
    public Carrinho get(Long id) {
        return carrinhoDAO.get(id);
    }

    @Override
    public void save(Carrinho carrinho) {
        carrinhoDAO.save(carrinho);
    }

    @Override
    public void delete(Long id) {
        carrinhoDAO.delete(id);
    }
}
