package com.squad2.locadoradeveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.squad2.locadoradeveiculos.model.Veiculo;
import com.squad2.locadoradeveiculos.service.VeiculoService;

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
}
