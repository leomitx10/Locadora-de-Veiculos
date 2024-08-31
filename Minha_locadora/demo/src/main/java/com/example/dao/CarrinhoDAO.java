package com.example.dao;

import com.example.demo.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CarrinhoDAO extends JpaRepository<Carrinho, Long> {
    Carrinho findByUserId(Long userId);
}

