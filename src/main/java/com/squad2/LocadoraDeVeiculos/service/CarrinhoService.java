package com.squad2.LocadoraDeVeiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carrinho;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AluguelRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarrinhoRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;

import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AluguelRepository aluguelRepository;


    public Carrinho criarCarrinho() {
        Carrinho carrinho = new Carrinho();
        return carrinhoRepository.save(carrinho);
    }

    public String adicionarCarroAoCarrinho(Long carrinhoId, Long carroId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Carro> carroOpt = carroRepository.findById(carroId);

        if (carrinhoOpt.isPresent() && carroOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Carro carro = carroOpt.get();
            carrinho.getCarros().add(carro);
            carrinhoRepository.save(carrinho);
            return "Carro adicionado ao carrinho.";
        }
        return "Carrinho ou Carro não encontrado.";
    }

    public String removerCarroDoCarrinho(Long carrinhoId, Long carroId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Carro> carroOpt = carroRepository.findById(carroId);

        if (carrinhoOpt.isPresent() && carroOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Carro carro = carroOpt.get();
            if (carrinho.getCarros().remove(carro)) {
                carrinhoRepository.save(carrinho);
                return "Carro removido do carrinho.";
            } else {
                return "Carro não encontrado no carrinho.";
            }
        }
        return "Carrinho ou Carro não encontrado.";
    }


    public String adicionarAluguelAoCarrinho(Long carrinhoId, Long aluguelId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);
        Optional<Aluguel> aluguelOpt = aluguelRepository.findById(aluguelId);

        if (carrinhoOpt.isPresent() && aluguelOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Aluguel aluguel = aluguelOpt.get();
            carrinho.setAluguel(aluguel);
            carrinhoRepository.save(carrinho);
            return "Aluguel adicionado ao carrinho.";
        }
        return "Carrinho ou Aluguel não encontrado.";
    }

    public String removerAluguelDoCarrinho(Long carrinhoId, Long aluguelId) {
        Optional<Carrinho> carrinhoOpt = carrinhoRepository.findById(carrinhoId);

        if (carrinhoOpt.isPresent()) {
            Carrinho carrinho = carrinhoOpt.get();
            Aluguel aluguel = carrinho.getAluguel();
            if (aluguel != null && aluguel.getId().equals(aluguelId)) {
                carrinho.setAluguel(null);
                carrinhoRepository.save(carrinho);
                return "Aluguel removido do carrinho.";
            } else {
                return "Aluguel não encontrado no carrinho.";
            }
        }
        return "Carrinho não encontrado.";
    }

    public Carrinho obterCarrinhoPorId(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId).orElse(null);
    }

    public Carrinho obterCarrinhoComDetalhes(Long carrinhoId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElse(null);

        if (carrinho != null) {
            carrinho.getCarros().forEach(carro -> {
                carro.getAcessorios().size();
            });

            if (carrinho.getAluguel() != null) {
                carrinho.getAluguel().getApoliceSeguro();
            }
        }

        return carrinho;
    }
}