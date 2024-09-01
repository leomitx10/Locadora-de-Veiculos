package com.squad2.LocadoraDeVeiculos.repository;

import com.squad2.LocadoraDeVeiculos.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
