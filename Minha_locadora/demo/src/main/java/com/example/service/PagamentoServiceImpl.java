package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Pagamento;
import com.example.dao.PagamentoDAO;
import com.example.demo.Carro;
import com.example.dao.CarroDAO;
import com.example.demo.Carrinho;
import com.example.dao.CarrinhoDAO;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoDAO pagamentoDAO;
    
    @Autowired
    private CarroDAO carroDAO;
    
    @Autowired
    private CarrinhoDAO carrinhoDAO;

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
    public void confirmarPorCarrinhoId(Long carrinhoId) {
        Carrinho carrinho = carrinhoDAO.get(carrinhoId);
        if (carrinho != null && carrinho.getAluguel() != null) {
            Carro carro = carrinho.getAluguel().getCarro();
            if (carro != null) {
                carro.setReservado(true);
                carroDAO.save(carro);
            } else {
                throw new RuntimeException("Carro not found in aluguel for Carrinho Id: " + carrinhoId);
            }
        } else {
            throw new RuntimeException("Carrinho not found for the Id: " + carrinhoId);
        }
    }
}
