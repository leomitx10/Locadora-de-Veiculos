package com.example.service;

import com.example.demo.Carrinho;
import com.example.demo.Carro;

public interface CarrinhoService {
    Carrinho addCarroToCarrinho(Carro carro, Long userId, String dataEntrega, String dataDevolucao);
    Carrinho getCarrinho(Long userId);
    Carrinho updateCarrinho(Carrinho carrinho);
    String confirmarReserva(Long userId);
}

