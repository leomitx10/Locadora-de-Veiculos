package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Carrinho;

public interface CarrinhoDAO {

    List<Carrinho> get();

    Carrinho get(Long id);

    void save(Carrinho carrinho);

    void delete(Long id);
}
