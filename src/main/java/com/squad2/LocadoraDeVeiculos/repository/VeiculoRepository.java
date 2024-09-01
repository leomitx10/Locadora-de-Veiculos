package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}