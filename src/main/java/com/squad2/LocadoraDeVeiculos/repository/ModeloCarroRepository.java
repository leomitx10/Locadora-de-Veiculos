package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.ModeloCarro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
