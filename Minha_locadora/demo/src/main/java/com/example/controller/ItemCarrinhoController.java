package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ItemCarrinho;
import com.example.service.ItemCarrinhoService;

@RestController
@RequestMapping("/api/item-carrinho")
public class ItemCarrinhoController {

    @Autowired
    private ItemCarrinhoService itemCarrinhoService;

    @PostMapping
    public ItemCarrinho save(@RequestBody ItemCarrinho itemCarrinho) {
        itemCarrinhoService.save(itemCarrinho);
        return itemCarrinho;
    }

    @GetMapping
    public List<ItemCarrinho> getAll() {
        return itemCarrinhoService.getAll();
    }

    @GetMapping("/{id}")
    public ItemCarrinho getById(@PathVariable Long id) {
        ItemCarrinho itemCarrinho = itemCarrinhoService.getById(id);
        if (itemCarrinho == null) {
            throw new RuntimeException("ItemCarrinho não encontrado para o Id: " + id);
        }
        return itemCarrinho;
    }

    @PutMapping
    public ItemCarrinho update(@RequestBody ItemCarrinho itemCarrinho) {
        itemCarrinhoService.update(itemCarrinho);
        return itemCarrinho;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        itemCarrinhoService.delete(id);
        return "ItemCarrinho deletado com sucesso, Id: " + id;
    }
}
