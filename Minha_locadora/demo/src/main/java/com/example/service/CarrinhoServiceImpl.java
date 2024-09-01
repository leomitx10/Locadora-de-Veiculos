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

    @Autowired
    private AluguelService aluguelService; // Injetar AluguelService

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
    public List<Carrinho> getByUserId(Long userId) {
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
    public void addAluguelToCarrinho(Long carrinhoId, Long aluguelId) {
        Carrinho carrinho = entityManager.find(Carrinho.class, carrinhoId);
        if (carrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o Id: " + carrinhoId);
        }

        Aluguel aluguel = entityManager.find(Aluguel.class, aluguelId);
        if (aluguel == null) {
            throw new RuntimeException("Aluguel não encontrado para o Id: " + aluguelId);
        }

        aluguel.setCarrinho(carrinho);
        entityManager.merge(aluguel);
    }
    
    @Override
    public List<Aluguel> getAlugueisByCarrinhoId(Long carrinhoId) {
        String queryStr = "SELECT a FROM Aluguel a WHERE a.carrinho.id = :carrinhoId";
        return entityManager.createQuery(queryStr, Aluguel.class)
                            .setParameter("carrinhoId", carrinhoId)
                            .getResultList();
    }

    @Override
    @Transactional
    public void reservarCarrosDoCarrinho(Long carrinhoId) {
        List<Aluguel> alugueis = getAlugueisByCarrinhoId(carrinhoId);
        for (Aluguel aluguel : alugueis) {
            // Usar o método reservarCarroDoAluguel do AluguelService
            aluguelService.reservarCarroDoAluguel(aluguel.getId());
        }
    }
}
