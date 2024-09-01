package com.squad2.LocadoraDeVeiculos.dao;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class FabricanteDAOImpl implements FabricanteDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Fabricante save(Fabricante fabricante) {
        if (fabricante.getId() == null) {
            entityManager.persist(fabricante);
            return fabricante;
        } else {
            return entityManager.merge(fabricante);
        }
    }

    @Override
    public Optional<Fabricante> findById(Long id) {
        Fabricante fabricante = entityManager.find(Fabricante.class, id);
        return Optional.ofNullable(fabricante);
    }

    @Override
    public List<Fabricante> findAll() {
        return entityManager.createQuery("SELECT f FROM Fabricante f", Fabricante.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Fabricante fabricante = entityManager.find(Fabricante.class, id);
        if (fabricante != null) {
            entityManager.remove(fabricante);
        }
    }
}