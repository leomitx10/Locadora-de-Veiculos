package com.example.dao;

import java.util.List;
import com.example.demo.ItemCarrinho;

public interface ItemCarrinhoDAO {
    void save(ItemCarrinho modeloCarro);
    List<ItemCarrinho> getAll();
    ItemCarrinho getById(Long id);
    void update(ItemCarrinho modeloCarro);
    void delete(Long id);
}
