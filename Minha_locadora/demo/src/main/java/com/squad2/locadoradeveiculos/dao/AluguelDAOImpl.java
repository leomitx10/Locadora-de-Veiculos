package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import jakarta.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.squad2.locadoradeveiculos.model.Aluguel;

@Repository
public class AluguelDAOImpl implements AluguelDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Aluguel> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Aluguel> query = currentSession.createQuery("from Aluguel", Aluguel.class);
        return query.getResultList();
    }

    @Override
    public Aluguel get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Aluguel.class, id);
    }

    @Override
    public void save(Aluguel aluguel) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(aluguel);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Aluguel aluguel = currentSession.get(Aluguel.class, id);
        currentSession.delete(aluguel);
    }

    @Override
    public List<Aluguel> getByUserId(Long userId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Aluguel> query = currentSession.createQuery("from Aluguel where user.id = :userId", Aluguel.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Aluguel> findByMotoristaId(Integer motoristaId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Aluguel> query = currentSession.createQuery("from Aluguel where motorista.id = :motoristaId", Aluguel.class);
        query.setParameter("motoristaId", motoristaId);
        return query.getResultList();
}
}