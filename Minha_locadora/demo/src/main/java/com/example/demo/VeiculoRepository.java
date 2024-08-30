package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    List<Veiculo> findByDisponivelTrue();  // Retorna apenas os veículos disponíveis
    List<Veiculo> findByCategoriaAndDisponivelTrue(String categoria); // Filtra por categoria e disponibilidade
}
