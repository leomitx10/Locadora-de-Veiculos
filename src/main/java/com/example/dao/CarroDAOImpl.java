package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Carro;

import jakarta.persistence.EntityManager;

@Repository
public class CarroDAOImpl implements CarroDAO {
    
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Carro> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Carro> query = currentSession.createQuery("from Carro", Carro.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Carro get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Carro.class, id);
    }

    @Override
    @Transactional
    public void save(Carro carro) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(carro);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Carro carro = currentSession.get(Carro.class, id);
        if (carro != null) {
            currentSession.delete(carro);
        }
    }
}
