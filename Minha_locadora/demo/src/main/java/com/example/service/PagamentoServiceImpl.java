package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Pagamento;
import com.example.dao.PagamentoDAO;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoDAO pagamentoDAO;

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
}
