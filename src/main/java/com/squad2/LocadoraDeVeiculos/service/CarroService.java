package com.squad2.LocadoraDeVeiculos.service;


import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private EntityManager entityManager;

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

    public void resetarIdCarro() {
        entityManager.createNativeQuery("ALTER TABLE carros AUTO_INCREMENT = 1")
                .executeUpdate();
    }
}
