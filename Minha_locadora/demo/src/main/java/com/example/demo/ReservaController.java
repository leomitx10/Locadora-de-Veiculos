package com.example.demo;
import com.example.demo.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private ClienteService clienteService;  // Serviço para manipulação de clientes

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/confirmar")
    public Reserva confirmarReserva(@RequestParam Long clienteId,
                                    @RequestParam Long veiculoId,
                                    @RequestParam String dataInicio,
                                    @RequestParam String dataFim) {
        Cliente cliente = clienteService.buscarPorId(clienteId);
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(veiculoId);

        return reservaService.criarReserva(cliente, veiculo, LocalDate.parse(dataInicio), LocalDate.parse(dataFim));
    }

    @GetMapping("/cliente/{clienteId}")
    public List<Reserva> listarReservasPorCliente(@PathVariable Long clienteId) {
        return reservaService.listarReservasPorCliente(clienteId);
    }

    // Endpoint para revisão e confirmação de pagamento

    @PostMapping("/confirmar-pagamento")
    public String confirmarPagamento(@RequestParam Long reservaId) {
        Reserva reserva = reservaService.buscarPorId(reservaId);
        if (reserva != null && "Confirmada".equals(reserva.getStatus())) {
            reserva.setStatus("Pagamento Confirmado");
            reservaService.salvar(reserva);
            return "Pagamento confirmado com sucesso!";
        }
        return "Erro ao confirmar pagamento!";
    }


}
