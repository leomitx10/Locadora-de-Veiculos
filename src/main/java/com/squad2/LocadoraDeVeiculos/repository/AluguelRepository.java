package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AluguelRepository extends JpaRepository<Aluguel, Long> {
}
