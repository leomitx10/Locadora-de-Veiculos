package com.squad2.locadoradeveiculos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad2.locadoradeveiculos.model.Veiculo;
import com.squad2.locadoradeveiculos.model.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarVeiculosDisponiveis() {
        return veiculoRepository.findByDisponivelTrue();
    }

    public List<Veiculo> filtrarVeiculosPorCategoria(String categoria) {
        return veiculoRepository.findByCategoriaAndDisponivelTrue(categoria);
    }

    public Veiculo buscarVeiculoPorId(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }
}
