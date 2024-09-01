package com.example.service;

import java.util.List;

import com.example.demo.Aluguel;
import com.example.demo.Carrinho;

public interface CarrinhoService {

    List<Carrinho> get();

    Carrinho get(Long id);

    List<Carrinho> getByUserId(Long userId);

    void save(Carrinho carrinho);

    void delete(Long id);
    
    void addAluguelToCarrinho(Long carrinhoId, Long aluguelId);

    List<Aluguel> getAlugueisByCarrinhoId(Long carrinhoId);

    // Novo método para reservar carros de aluguéis associados ao carrinho
    void reservarCarrosDoCarrinho(Long carrinhoId);
}
