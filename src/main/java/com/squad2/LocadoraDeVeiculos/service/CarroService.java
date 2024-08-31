package com.squad2.LocadoraDeVeiculos.service;


import com.squad2.LocadoraDeVeiculos.model.entity.Acessorio;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AcessorioRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String associarAcessorioAoCarro(Long carroId, Long acessorioId) {
        Carro carro = carroRepository.findById(carroId).orElse(null);
        Acessorio acessorio = acessorioRepository.findById(acessorioId).orElse(null);

        if (carro == null) {
            return "Carro não encontrado.";
        }
        if (acessorio == null) {
            return "Acessório não encontrado.";
        }

        carro.getAcessorios().add(acessorio);
        carroRepository.save(carro);
        return "Acessório associado ao carro.";
    }

    public String desassociarAcessorioDoCarro(Long carroId, Long acessorioId) {
        Carro carro = carroRepository.findById(carroId).orElse(null);

        if (carro == null) {
            return "Carro não encontrado.";
        }

        Acessorio acessorio = acessorioRepository.findById(acessorioId).orElse(null);

        if (acessorio == null || !carro.getAcessorios().contains(acessorio)) {
            return "Acessório não encontrado no carro.";
        }

        carro.getAcessorios().remove(acessorio);
        carroRepository.save(carro);
        return "Acessório desassociado do carro.";
    }

    public String salvar(Carro carro){
        carroRepository.save(carro);
        return "Carro salvo.";
    }

    public List<Carro> listar(){
        return carroRepository.findAll();
    }

    public String modificar(Carro carro){
        carroRepository.save(carro);
        return "Carro modificado.";
    }

    public String deletar(Long id){
        carroRepository.deleteById(id);
        return "Exclusão de carro realizada.";
    }

    //get carro com acessorio so aparece array
    public Carro obterCarroComAcessorios(Long carroId) {
        return carroRepository.findById(carroId).orElse(null);
    }
}
