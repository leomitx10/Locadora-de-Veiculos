package com.example.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Carrinho;

@Repository
public class CarrinhoDAOImpl implements CarrinhoDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrinho> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Carrinho> query = currentSession.createQuery("from Carrinho", Carrinho.class);
        List<Carrinho> list = query.getResultList();
        return list;
    }

    @Override
    public Carrinho get(Long id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Carrinho carrinhoObj = currentSession.get(Carrinho.class, id);
        return carrinhoObj;
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
