package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.ApoliceSeguro;
import com.squad2.LocadoraDeVeiculos.repository.ApoliceSeguroRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ApoliceSeguroService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Autowired
    private EntityManager entityManager;


    public String salvar(ApoliceSeguro apoliceSeguro){
        BigDecimal valorFranquia = apoliceSeguro.getValorFranquia();
        if (valorFranquia == null) {
            return "o valor não pode ser nulo.";
        }
        apoliceSeguroRepository.save(apoliceSeguro);
        return "Apolice seguro salvo.";
    }

    public List<ApoliceSeguro> listar(){return apoliceSeguroRepository.findAll();}

    public String modificar(ApoliceSeguro apoliceSeguro){
        BigDecimal valorFranquia = apoliceSeguro.getValorFranquia();
        if (valorFranquia == null) {
            return "o valor não pode ser nulo.";
        }
        apoliceSeguroRepository.save(apoliceSeguro);
        return "Apolice seguro modificado.";
         }

    public String deletar(Long id){
        apoliceSeguroRepository.deleteById(id);
        return "Exclusão de apolice seguro realizada.";
    }

    public void resetarIdApoliceSeguro() {
        entityManager.createNativeQuery("ALTER TABLE apolice AUTO_INCREMENT = 1")
                .executeUpdate();
    }

    public ApoliceSeguro getApoliceSeguro(Long id) {
        return apoliceSeguroRepository.findById(id).orElse(null);
    }
}