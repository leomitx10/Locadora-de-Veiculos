package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Pagamento;

public interface PagamentoDAO {
    List<Pagamento> get();

    Pagamento get(Long id);

    void save(Pagamento pagamento);

    void delete(Long id);
}
