package com.example.service;

import java.util.List;
import com.example.demo.Pagamento;

public interface PagamentoService {

    List<Pagamento> get();

    Pagamento get(Long id);

    void save(Pagamento pagamento);

    void delete(Long id);
    
    void confirmar(Long carroId);
    
    void reservarCarrosDoCarrinho(Long carrinhoId);
    
}
