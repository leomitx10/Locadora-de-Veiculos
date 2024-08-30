package com.example.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.ModeloCarro;

@Repository
@Transactional
public class ModeloCarroDAOImpl implements ModeloCarroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ModeloCarro modeloCarro) {
        entityManager.persist(modeloCarro);
    }

    @Override
    public List<ModeloCarro> getAll() {
        return entityManager.createQuery("from ModeloCarro", ModeloCarro.class).getResultList();
    }

    @Override
    public ModeloCarro getById(Long id) {
        return entityManager.find(ModeloCarro.class, id);
    }

    @Override
    public void update(ModeloCarro modeloCarro) {
        entityManager.merge(modeloCarro);
    }

    @Override
    public void delete(Long id) {
        ModeloCarro modeloCarro = getById(id);
        if (modeloCarro != null) {
            entityManager.remove(modeloCarro);
        }
    }
}