package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.websocket.Session;


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

    @Override
    public List<Carro> getByCategoria(Categoria categoria) {
        TypedQuery<Carro> query = entityManager.createQuery(
                "SELECT c FROM Carro c WHERE c.modeloCarro.categoria = :categoria", Carro.class
        );
        query.setParameter("categoria", categoria);
        return query.getResultList();
    }

    @Override
    public List<Carro> getByAcessorio(String acessorio) {
        TypedQuery<Carro> query = entityManager.createQuery(
                "SELECT c FROM Carro c JOIN c.acessorios a WHERE a.descricao = :acessorio", Carro.class
        );
        query.setParameter("acessorio", acessorio);
        return query.getResultList();
    }


}