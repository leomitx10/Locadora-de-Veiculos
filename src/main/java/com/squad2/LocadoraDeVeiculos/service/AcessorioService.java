package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.Acessorio;
import com.squad2.LocadoraDeVeiculos.repository.AcessorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    public String salvar(Acessorio acessorio){
        acessorioRepository.save(acessorio);
        return "Acessório salvo.";
    }

    public List<Acessorio> listar() {return acessorioRepository.findAll();
    }

    public String modificar(Acessorio acessorio){
        acessorioRepository.save(acessorio);
        return "Acessório modificado.";
    }

    public String deletar(Long id){
        Optional<Acessorio> optionalAcessorio = acessorioRepository.findById(id);
        if(!optionalAcessorio.isPresent()){
            return "Acessório não encontrado.";
        }
        Acessorio acessorio = optionalAcessorio.get();
        acessorioRepository.deleteById(id);
        return String.format("Exclusão do acessório realizada. Acessório excluído: [ID: %d, Descrição: %s]",
                acessorio.getId(), acessorio.getDescricao());
    }
}
