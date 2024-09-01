package com.example.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AluguelDAO;
import com.example.dao.CarroDAO;  
import com.example.demo.Aluguel;
import com.example.demo.ApoliceSeguro;
import com.example.demo.Carro; 

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelDAO aluguelDAO;

    @Autowired
    private ApoliceService apoliceService; 

    @Autowired
    private CarroDAO carroDAO;  

    @Transactional
    @Override
    public List<Aluguel> get() {
        return aluguelDAO.get();
    }

    @Transactional
    @Override
    public Aluguel get(int id) {
        return aluguelDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Aluguel aluguel) {
        if (aluguel.getDataDevolucao() != null && aluguel.getDataEntrega() != null &&
            aluguel.getCarro() != null && aluguel.getApolice() != null) {

            long diffInMillis = aluguel.getDataDevolucao().getTime() - aluguel.getDataEntrega().getTime();
            long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

            Carro carro = carroDAO.get(aluguel.getCarro().getId());
            BigDecimal valorDiaria = carro.getValorDiaria();
            
            ApoliceSeguro apolice = apoliceService.get(aluguel.getApolice().getId());
            BigDecimal valorFranquia = apolice.getValorFranquia();
            
            BigDecimal valorTotal = valorDiaria.multiply(BigDecimal.valueOf(diffInDays)).add(valorFranquia);

            aluguel.setValorTotal(valorTotal);
        }
        aluguelDAO.save(aluguel);
    }

    @Transactional
    @Override
    public void delete(int id) {
        aluguelDAO.delete(id);
    }

    @Transactional
    @Override
    public List<Aluguel> getByUserId(Long userId) {
        return aluguelDAO.getByUserId(userId);
    }
    
    @Transactional
    @Override
    public void reservarCarroDoAluguel(int aluguelId) {
        Aluguel aluguel = aluguelDAO.get(aluguelId);
        if (aluguel != null) {
            Carro carro = aluguel.getCarro();
            if (carro != null) {
                carro.setReservado(true);
                carroDAO.save(carro);
            } else {
                throw new RuntimeException("Carro não encontrado para o aluguel com id: " + aluguelId);
            }
        } else {
            throw new RuntimeException("Aluguel não encontrado com id: " + aluguelId);
        }
    }
}
