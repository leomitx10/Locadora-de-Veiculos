package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Carrinho;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CarrinhoDAOImpl implements CarrinhoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrinho> getAll() {
        TypedQuery<Carrinho> query = entityManager.createQuery("FROM Carrinho", Carrinho.class);
        return query.getResultList();
    }

    @Override
    public Carrinho getById(Long id) {
        return entityManager.find(Carrinho.class, id);
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
        Carrinho carrinho = entityManager.find(Carrinho.class, id);
        if (carrinho != null) {
            entityManager.remove(carrinho);
        }
    }
}
