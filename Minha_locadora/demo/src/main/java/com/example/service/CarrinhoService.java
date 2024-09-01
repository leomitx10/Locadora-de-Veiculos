package com.example.service;

import java.util.List;

import com.example.demo.Aluguel;
import com.example.demo.Carrinho;

public interface CarrinhoService {

    List<Carrinho> get();

    Carrinho get(Long id);

    List<Carrinho> getByUserId(Long userId); // Novo método

    void save(Carrinho carrinho);

    void delete(Long id);
    
    void addAluguelToCarrinho(Long userId, Long aluguelId);

    List<Aluguel> getAlugueisByCarrinhoId(Long carrinhoId);
}
