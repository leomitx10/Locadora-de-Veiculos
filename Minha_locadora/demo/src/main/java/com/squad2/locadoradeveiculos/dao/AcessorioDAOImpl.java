package com.squad2.locadoradeveiculos.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.squad2.locadoradeveiculos.model.Acessorio;

@Repository
public class AcessorioDAOImpl implements AcessorioDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Acessorio> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Acessorio> query = currentSession.createQuery("from Acessorio", Acessorio.class);
        List<Acessorio> list = query.getResultList();
        return list;
    }

    @Override
    public Acessorio get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Acessorio acessorioObj = currentSession.get(Acessorio.class, id);
        return acessorioObj;
    }

    @Override
    public void save(Acessorio acessorio) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(acessorio);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Acessorio acessorio = currentSession.get(Acessorio.class, id);
        if (acessorio != null) {
            currentSession.delete(acessorio);
        }
    }
}