package com.squad2.LocadoraDeVeiculos.service;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carrinho;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AluguelRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarrinhoRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private EntityManager entityManager;

    public Carrinho criarCarrinho() {
        Carrinho carrinho = new Carrinho();
        return carrinhoRepository.save(carrinho);
    }

    public String adicionarCarroAoCarrinho(Long carrinhoId, Carro carro) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            carrinho.getCarros().add(carro);
            carrinhoRepository.save(carrinho);
            return "Carro adicionado ao carrinho.";
        } else {
            return "Carrinho não encontrado.";
        }
    }

    public String removerCarroDoCarrinho(Long carrinhoId, Long carroId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            Carro carro = carroRepository.findById(carroId).orElse(null);
            if (carro != null && carrinho.getCarros().remove(carro)) {
                carrinhoRepository.save(carrinho);
                return "Carro removido do carrinho.";
            } else {
                return "Carro não encontrado no carrinho.";
            }
        } else {
            return "Carrinho não encontrado.";
        }
    }

    public void resetarIdCarrinho() {
        entityManager.createNativeQuery("ALTER TABLE carrinho AUTO_INCREMENT = 1")
                .executeUpdate();
    }

    public String adicionarAluguelAoCarrinho(Long carrinhoId, Aluguel aluguel) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            carrinho.setAluguel(aluguel);
            carrinhoRepository.save(carrinho);
            return "Aluguel adicionado ao carrinho.";
        } else {
            return "Carrinho não encontrado.";
        }
    }

    public String removerAluguelDoCarrinho(Long carrinhoId, Long aluguelId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);
        if (carrinho != null) {
            Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);
            if (aluguel != null && aluguel.equals(carrinho.getAluguel()))  {
                carrinho.setAluguel(null);
                carrinhoRepository.save(carrinho);
                return "Aluguel removido do carrinho.";
            } else {
                return "Aluguel não encontrado no carrinho.";
            }
        } else {
            return "Carrinho não encontrado.";
        }
    }

    public Carrinho obterCarrinhoPorId(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId).orElse(null);
    }
}
