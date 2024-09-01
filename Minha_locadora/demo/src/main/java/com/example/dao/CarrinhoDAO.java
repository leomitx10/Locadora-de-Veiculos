package com.example.dao;

import java.util.List;

import com.example.demo.Carrinho;

public interface CarrinhoDAO {

    List<Carrinho> get();

    Carrinho get(Long id);

    void save(Carrinho carrinho);

    void delete(Long id);
}
