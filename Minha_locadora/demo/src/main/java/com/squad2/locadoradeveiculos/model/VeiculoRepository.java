package com.squad2.locadoradeveiculos.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByDisponivelTrue();
    List<Veiculo> findByCategoriaAndDisponivelTrue(String categoria);
}
