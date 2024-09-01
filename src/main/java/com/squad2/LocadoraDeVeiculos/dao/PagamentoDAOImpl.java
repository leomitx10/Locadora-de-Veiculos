package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PagamentoDAOImpl implements PagamentoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Pagamento> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Pagamento> query = currentSession.createQuery("from Pagamento", Pagamento.class);
        return query.getResultList();
    }

    @Override
    public Pagamento get(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Pagamento.class, id);
    }

    @Override
    public void save(Pagamento pagamento) {
        Session currentSession = entityManager.unwrap(Session.class);
        if (pagamento.getId() == null) {
            currentSession.persist(pagamento);
        } else {
            currentSession.merge(pagamento);
        }
    }

    @Override
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Pagamento pagamento = currentSession.get(Pagamento.class, id);
        if (pagamento != null) {
            currentSession.remove(pagamento);
        }
    }
}