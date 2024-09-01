package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
