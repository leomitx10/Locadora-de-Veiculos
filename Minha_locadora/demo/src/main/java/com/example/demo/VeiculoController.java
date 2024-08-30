package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/disponiveis")
    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoService.listarVeiculosDisponiveis();
    }

    @GetMapping("/filtrar")
    public List<Veiculo> filtrarVeiculos(@RequestParam String categoria) {
        return veiculoService.filtrarVeiculosPorCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Veiculo buscarVeiculo(@PathVariable Long id) {
        return veiculoService.buscarVeiculoPorId(id);
    }

    // Endpoint para adicionar ao carrinho, etc.
}
