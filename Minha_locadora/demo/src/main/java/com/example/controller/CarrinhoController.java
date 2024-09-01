package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Carrinho;
import com.example.service.CarrinhoService;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public Carrinho save(@RequestBody Carrinho carrinho) {
        carrinhoService.save(carrinho);
        return carrinho;
    }

    @GetMapping
    public List<Carrinho> getAll() {
        return carrinhoService.getAll();
    }

    @GetMapping("/{id}")
    public Carrinho getById(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.getById(id);
        if (carrinho == null) {
            throw new RuntimeException("Carrinho not found for the Id: " + id);
        }
        return carrinho;
    }

    @PutMapping
    public Carrinho update(@RequestBody Carrinho carrinho) {
        carrinhoService.save(carrinho);
        return carrinho;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        carrinhoService.delete(id);
        return "Carrinho has been deleted with id: " + id;
    }
}
