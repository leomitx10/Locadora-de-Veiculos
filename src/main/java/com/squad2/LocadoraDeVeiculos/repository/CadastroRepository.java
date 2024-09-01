package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {
}
