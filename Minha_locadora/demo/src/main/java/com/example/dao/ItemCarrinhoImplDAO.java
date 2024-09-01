package com.example.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.example.demo.ItemCarrinho;

@Repository
@Transactional
public class ItemCarrinhoImplDAO implements ItemCarrinhoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(ItemCarrinho itemCarrinho) {
        entityManager.persist(itemCarrinho);
    }

    @Override
    public List<ItemCarrinho> getAll() {
        return entityManager.createQuery("from ItemCarrinho", ItemCarrinho.class).getResultList();
    }

    @Override
    public ItemCarrinho getById(Long id) {
        return entityManager.find(ItemCarrinho.class, id);
    }

    @Override
    public void update(ItemCarrinho itemCarrinho) {
        entityManager.merge(itemCarrinho);
    }

    @Override
    public void delete(Long id) {
        ItemCarrinho itemCarrinho = getById(id);
        if (itemCarrinho != null) {
            entityManager.remove(itemCarrinho);
        }
    }
}
