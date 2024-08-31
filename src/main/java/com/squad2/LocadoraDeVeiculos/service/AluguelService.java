package com.squad2.LocadoraDeVeiculos.service;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.ApoliceSeguro;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.repository.AluguelRepository;
import com.squad2.LocadoraDeVeiculos.repository.ApoliceSeguroRepository;
import com.squad2.LocadoraDeVeiculos.repository.CarroRepository;
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
    private ApoliceSeguroRepository apoliceSeguroRepository;

    public String associarApoliceAoAluguel(Long aluguelId, Long apoliceId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);
        ApoliceSeguro apolice = apoliceSeguroRepository.findById(apoliceId).orElse(null);

        if (aluguel == null) {
            return "Aluguel não encontrado.";
        }
        if (apolice == null) {
            return "Apólice não encontrada.";
        }

        aluguel.setApoliceSeguro(apolice);
        aluguelRepository.save(aluguel);
        return "Apólice associada ao aluguel.";
    }

    public String desassociarApoliceDoAluguel(Long aluguelId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);

        if (aluguel == null) {
            return "Aluguel não encontrado.";
        }

        aluguel.setApoliceSeguro(null);
        aluguelRepository.save(aluguel);
        return "Apólice desassociada do aluguel.";
    }


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

    public void calcularValorTotalAluguel(Long aluguelId, Long carroId) {
        Aluguel aluguel = aluguelRepository.findById(aluguelId).orElse(null);
        Carro carro = carroRepository.findById(carroId).orElse(null);

        if (aluguel != null && carro != null) {
            long diasAluguel = ChronoUnit.DAYS.between(aluguel.getDataEntrega(), aluguel.getDataDevolucao());
            BigDecimal valorTotal = carro.getValorDiaria().multiply(BigDecimal.valueOf(diasAluguel));

            if (aluguel.getApoliceSeguro() != null) {
                BigDecimal valorFranquia = aluguel.getApoliceSeguro().getValorFranquia();
                valorTotal = valorTotal.add(valorFranquia != null ? valorFranquia : BigDecimal.ZERO);
            }

            aluguel.setValorTotal(valorTotal);
            aluguelRepository.save(aluguel);
        }
    }
}
