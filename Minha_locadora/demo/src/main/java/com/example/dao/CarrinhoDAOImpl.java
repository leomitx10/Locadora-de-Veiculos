package com.example.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Carrinho;
import jakarta.persistence.EntityManager;

@Repository
public class CarrinhoDAOImpl implements CarrinhoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrinho> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Carrinho> query = currentSession.createQuery("from Carrinho", Carrinho.class);
        return query.getResultList();
    }

    @Override
    public Carrinho get(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Carrinho.class, id);
    }

    @Override
    public void save(Carrinho carrinho) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(carrinho);
    }

    @Override
    public void delete(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Carrinho carrinho = currentSession.get(Carrinho.class, id);
        if (carrinho != null) {
            currentSession.delete(carrinho);
        }
    }
}
