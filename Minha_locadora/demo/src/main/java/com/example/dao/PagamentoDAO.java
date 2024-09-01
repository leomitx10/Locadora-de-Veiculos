package com.example.dao;

import java.util.List;
import com.example.demo.Pagamento;

public interface PagamentoDAO {
    List<Pagamento> get();

    Pagamento get(Long id);

    void save(Pagamento pagamento);

    void delete(Long id);
}
