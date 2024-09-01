package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Aluguel;
import com.example.demo.Carrinho;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Carrinho> get() {
        String queryStr = "FROM Carrinho";
        return entityManager.createQuery(queryStr, Carrinho.class).getResultList();
    }

    @Override
    public Carrinho get(Long id) {
        return entityManager.find(Carrinho.class, id);
    }

    @Override
    public List<Carrinho> getByUserId(Long userId) { // Implementação do novo método
        String queryStr = "FROM Carrinho WHERE user.id = :userId";
        return entityManager.createQuery(queryStr, Carrinho.class)
                            .setParameter("userId", userId)
                            .getResultList();
    }

    @Override
    public void save(Carrinho carrinho) {
        if (carrinho.getId() == null) {
            entityManager.persist(carrinho);
        } else {
            entityManager.merge(carrinho);
        }
    }

    @Override
    public void delete(Long id) {
        Carrinho carrinho = get(id);
        if (carrinho != null) {
            entityManager.remove(carrinho);
        }
    }
    
    @Override
    @Transactional
    public void addAluguelToCarrinho(Long userId, Long aluguelId) {
        String queryStr = "FROM Carrinho WHERE user.id = :userId AND aluguel IS NULL";
        Carrinho carrinho = entityManager.createQuery(queryStr, Carrinho.class)
                                          .setParameter("userId", userId)
                                          .setMaxResults(1)
                                          .getSingleResult();

        if (carrinho != null) {
            Aluguel aluguel = entityManager.find(Aluguel.class, aluguelId);
            if (aluguel != null) {
                carrinho.setAluguel(aluguel);
                entityManager.merge(carrinho);
            } else {
                throw new RuntimeException("Aluguel não encontrado para o Id: " + aluguelId);
            }
        } else {
            throw new RuntimeException("Carrinho não encontrado para o UserId: " + userId + " ou já possui um Aluguel associado.");
        }
    }

}
