package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva salvar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Autowired
    private VeiculoRepository veiculoRepository;

    public Reserva criarReserva(Cliente cliente, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim) {
        long dias = ChronoUnit.DAYS.between(dataInicio, dataFim);
        double custoTotal = veiculo.getPrecoPorDia() * dias;

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setVeiculo(veiculo);
        reserva.setDataInicio(dataInicio);
        reserva.setDataFim(dataFim);
        reserva.setCustoTotal(custoTotal);
        reserva.setStatus("Confirmada");

        // Marcar o veículo como reservado
        veiculo.setReservado(true);
        veiculoRepository.save(veiculo);

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarReservasPorCliente(Long clienteId) {
        return reservaRepository.findByClienteId(clienteId);
    }

    // Outros métodos conforme necessário
}
