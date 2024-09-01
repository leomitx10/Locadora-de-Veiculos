package com.example.service;

import java.util.List;

import com.example.demo.Carrinho;

public interface CarrinhoService {
    List<Carrinho> getAll();
    Carrinho getById(Long id);
    void save(Carrinho carrinho);
    void delete(Long id);
}
