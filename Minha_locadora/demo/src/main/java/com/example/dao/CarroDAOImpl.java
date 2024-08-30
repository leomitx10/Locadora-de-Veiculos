package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Carro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CarroDAOImpl implements CarroDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carro> get() {
        TypedQuery<Carro> query = entityManager.createQuery("FROM Carro", Carro.class);
        return query.getResultList();
    }

    @Override
    public Carro get(Long id) {
        return entityManager.find(Carro.class, id);
    }

    @Override
    public void save(Carro carro) {
        if (carro.getId() == null) {
            entityManager.persist(carro);
        } else {
            entityManager.merge(carro);
        }
    }

    @Override
    public void delete(Long id) {
        Carro carro = entityManager.find(Carro.class, id);
        if (carro != null) {
            entityManager.remove(carro);
        }
    }
}
