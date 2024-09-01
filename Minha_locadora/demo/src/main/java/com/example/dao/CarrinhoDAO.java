package com.example.dao;

import java.util.List;

import com.example.demo.Carrinho;

public interface CarrinhoDAO {
    List<Carrinho> getAll();
    Carrinho getById(Long id);
    void save(Carrinho carrinho);
    void delete(Long id);
}
