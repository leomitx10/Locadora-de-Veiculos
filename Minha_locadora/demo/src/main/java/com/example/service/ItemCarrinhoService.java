package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ItemCarrinhoDAO;
import com.example.demo.ItemCarrinho;

@Service
public class ItemCarrinhoService {

    @Autowired
    private ItemCarrinhoDAO itemCarrinhoDAO;

    public void save(ItemCarrinho itemCarrinho) {
        itemCarrinhoDAO.save(itemCarrinho);
    }

    public List<ItemCarrinho> getAll() {
        return itemCarrinhoDAO.getAll();
    }

    public ItemCarrinho getById(Long id) {
        return itemCarrinhoDAO.getById(id);
    }

    public void update(ItemCarrinho itemCarrinho) {
        itemCarrinhoDAO.update(itemCarrinho);
    }

    public void delete(Long id) {
        itemCarrinhoDAO.delete(id);
    }
}
