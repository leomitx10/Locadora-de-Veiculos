package com.squad2.locadoradeveiculos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.squad2.locadoradeveiculos.dao.CarrinhoDAO;
import com.squad2.locadoradeveiculos.dao.CarroDAO;
import com.squad2.locadoradeveiculos.dao.PagamentoDAO;
import com.squad2.locadoradeveiculos.model.Carrinho;
import com.squad2.locadoradeveiculos.model.Carro;
import com.squad2.locadoradeveiculos.model.Pagamento;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoDAO pagamentoDAO;
    
    @Autowired
    private CarroDAO carroDAO;
    
    @Autowired
    private CarrinhoDAO carrinhoDAO;
    
    @Autowired
    private CarrinhoService carrinhoService; // Injetar CarrinhoService

    @Transactional(readOnly = true)
    @Override
    public List<Pagamento> get() {
        return pagamentoDAO.get();
    }

    @Transactional(readOnly = true)
    @Override
    public Pagamento get(Long id) {
        return pagamentoDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Pagamento pagamento) {
        pagamentoDAO.save(pagamento);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        pagamentoDAO.delete(id);
    }
    
    @Transactional
    @Override
    public void confirmar(Long carroId) {
        Carro carro = carroDAO.get(carroId);
        if (carro != null) {
            carro.setReservado(true);
            carroDAO.save(carro);
        } else {
            throw new RuntimeException("Carro not found for the Id: " + carroId);
        }
    }

    @Transactional
    @Override
    public void reservarCarrosDoCarrinho(Long carrinhoId) {
        // Usar o serviço CarrinhoService para reservar carros
        carrinhoService.reservarCarrosDoCarrinho(carrinhoId);
    }
}
