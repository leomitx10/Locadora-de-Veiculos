package com.example.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.demo.ApoliceSeguro;

@Repository
public class ApoliceDAOImpl implements ApoliceDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ApoliceSeguro> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<ApoliceSeguro> query = currentSession.createQuery("from ApoliceSeguro", ApoliceSeguro.class);
        return query.getResultList();
    }

    @Override
    public ApoliceSeguro get(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(ApoliceSeguro.class, id);
    }

    @Override
    public void save(ApoliceSeguro apolice) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(apolice);
    }

    @Override
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        ApoliceSeguro apolice = currentSession.get(ApoliceSeguro.class, id);
        if (apolice != null) {
            currentSession.delete(apolice);
        }
    }
}
