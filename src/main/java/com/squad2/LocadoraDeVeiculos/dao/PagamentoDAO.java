package com.squad2.LocadoraDeVeiculos.dao;

import java.util.List;

public interface PagamentoDAO {
    List<Pagamento> get();

    Pagamento get(Long id);

    void save(Pagamento pagamento);

    void delete(Long id);
}