package com.squad2.LocadoraDeVeiculos.repository;
import com.squad2.LocadoraDeVeiculos.model.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}

