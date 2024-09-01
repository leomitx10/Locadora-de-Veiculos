package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;
public interface CarrinhoDAO {

    List<Carrinho> get();

    Carrinho get(Long id);

    void save(Carrinho carrinho);

    void delete(Long id);
}