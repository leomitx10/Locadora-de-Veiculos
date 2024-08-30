package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AluguelRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private EntityManager entityManager;


    public String salvar(Aluguel aluguel){

        LocalDate dataEntrega = aluguel.getDataEntrega();
        LocalDate dataDevolucao = aluguel.getDataDevolucao();

        if (dataDevolucao == null || dataEntrega == null) {
            return "Data de entrega ou data de devolução não podem ser nulas.";
        }

        if (dataDevolucao.isBefore(dataEntrega)) {
            return "Data de devolução deve ser no mesmo dia ou após a data de entrega.";
        }

        aluguelRepository.save(aluguel);
        return "Aluguel salvo.";
    }

    public List<Aluguel> listar(){
        return aluguelRepository.findAll();
    }

    public String modificar(Aluguel aluguel){
        LocalDate dataEntrega = aluguel.getDataEntrega();
        LocalDate dataDevolucao = aluguel.getDataDevolucao();

        if (dataDevolucao == null || dataEntrega == null) {
            return "Data de entrega ou data de devolução não podem ser nulas.";
        }

        if (dataDevolucao.isBefore(dataEntrega)) {
            return "Data de devolução deve ser no mesmo dia ou após a data de entrega.";
        }

        aluguelRepository.save(aluguel);
        return "Aluguel modificado.";
    }


    public String deletar(Long id){
        aluguelRepository.deleteById(id);
        return "Exclusão de aluguel realizada.";
    }

    public void resetarIdAluguel() {
        entityManager.createNativeQuery("ALTER TABLE alugueis AUTO_INCREMENT = 1")
                .executeUpdate();
    }

    public void calcularValorTotalAluguel(Long aluguelId, Long carroId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);
        Carro carro = carroRepository.findById(carroId).orElse(null);

        if (aluguel != null && carro != null) {
            long diasAluguel = ChronoUnit.DAYS.between(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
            BigDecimal valorTotal = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel));
            aluguel.setValorTotal(valorTotal);
            aluguelRepository.save(aluguel);
        }
    }
}
