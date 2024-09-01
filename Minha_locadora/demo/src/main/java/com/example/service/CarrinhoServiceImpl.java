package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Carrinho;

import jakarta.persistence.EntityManager;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrinho> get() {
        String queryStr = "FROM Carrinho";
        return entityManager.createQuery(queryStr, Carrinho.class).getResultList();
    }

    @Override
    public Carrinho get(Long id) {
        return entityManager.find(Carrinho.class, id);
    }

    @Override
    public List<Carrinho> getByUserId(Long userId) { // Implementação do novo método
        String queryStr = "FROM Carrinho WHERE user.id = :userId";
        return entityManager.createQuery(queryStr, Carrinho.class)
                            .setParameter("userId", userId)
                            .getResultList();
    }

    @Override
    public void save(Carrinho carrinho) {
        if (carrinho.getId() == null) {
            entityManager.persist(carrinho);
        } else {
            entityManager.merge(carrinho);
        }
    }

    @Override
    public void delete(Long id) {
        Carrinho carrinho = get(id);
        if (carrinho != null) {
            entityManager.remove(carrinho);
        }
    }
}
