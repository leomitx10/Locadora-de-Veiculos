package com.example.service;

import com.example.dao.CarrinhoDAO;
import com.example.demo.Carrinho;
import com.example.demo.Carro;
import com.example.demo.ItemCarrinho;
import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CarrinhoServiceImpl implements CarrinhoService {

    @Autowired
    private CarrinhoDAO carrinhoDAO;

    @Override
    @Transactional
    public Carrinho addCarroToCarrinho(Carro carro, Long userId, String dataEntregaStr, String dataDevolucaoStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataEntrega = null;
        Date dataDevolucao = null;

        try {
            dataEntrega = sdf.parse(dataEntregaStr);
            dataDevolucao = sdf.parse(dataDevolucaoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Carrinho carrinho = carrinhoDAO.findByUserId(userId);

        if (carrinho == null) {
            carrinho = new Carrinho();
            carrinho.setUser(new User()); // Assuming User entity is populated elsewhere
            carrinho.setDataCriacao(new Date());
        }

        ItemCarrinho item = new ItemCarrinho();
        item.setCarro(carro);
        item.setCarrinho(carrinho);
        item.setDataEntrega(dataEntrega);
        item.setDataDevolucao(dataDevolucao);
        item.setValorTotal(carro.getValorDiaria().multiply(new BigDecimal((dataDevolucao.getTime() - dataEntrega.getTime()) / (1000 * 60 * 60 * 24)))); // Calculate total cost

        carrinho.getItens().add(item);
        carrinho.setValorTotal(carrinho.getValorTotal().add(item.getValorTotal()));

        return carrinhoDAO.save(carrinho);
    }

    @Override
    @Transactional(readOnly = true)
    public Carrinho getCarrinho(Long userId) {
        return carrinhoDAO.findByUserId(userId);
    }

    @Override
    @Transactional
    public Carrinho updateCarrinho(Carrinho carrinho) {
        if (carrinhoDAO.existsById(carrinho.getId())) {
            return carrinhoDAO.save(carrinho);
        } else {
            throw new RuntimeException("Carrinho não encontrado");
        }
    }

    @Override
    @Transactional
    public String confirmarReserva(Long userId) {
        Carrinho carrinho = carrinhoDAO.findByUserId(userId);

        if (carrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o usuário com ID: " + userId);
        }

        carrinhoDAO.deleteById(carrinho.getId()); // Use deleteById

        return "Reserva confirmada com sucesso!";
    }
}
