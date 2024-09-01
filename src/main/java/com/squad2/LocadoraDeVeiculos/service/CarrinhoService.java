package com.squad2.LocadoraDeVeiculos.service;

public interface CarrinhoService {

    List<Carrinho> get();

    Carrinho get(Long id);

    List<Carrinho> getByUserId(Long userId); // Novo método

    void save(Carrinho carrinho);

    void delete(Long id);

    void addAluguelToCarrinho(Long userId, Long aluguelId);

    List<Aluguel> getAlugueisByCarrinhoId(Long carrinhoId);
}