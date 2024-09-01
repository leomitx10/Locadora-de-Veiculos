package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Carrinho;
import com.example.service.CarrinhoService;

@RestController
@RequestMapping("/api")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/carrinhos")
    public Carrinho save(@RequestBody Carrinho carrinho) {
        carrinhoService.save(carrinho);
        return carrinho;
    }

    @GetMapping("/carrinhos")
    public List<Carrinho> get() {
        return carrinhoService.get();
    }

    @GetMapping("/carrinhos/{id}")
    public Carrinho get(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.get(id);
        if (carrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o Id: " + id);
        }
        return carrinho;
    }

    @GetMapping("/carrinhos/user/{userId}") // Novo endpoint para buscar carrinhos por user_id
    public List<Carrinho> getByUserId(@PathVariable Long userId) {
        return carrinhoService.getByUserId(userId);
    }

    @PutMapping("/carrinhos/{id}")
    public Carrinho update(@PathVariable Long id, @RequestBody Carrinho carrinho) {
        Carrinho existingCarrinho = carrinhoService.get(id);
        if (existingCarrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o Id: " + id);
        }
        carrinho.setId(id);
        carrinhoService.save(carrinho);
        return carrinho;
    }

    @DeleteMapping("/carrinhos/{id}")
    public String delete(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.get(id);
        if (carrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o Id: " + id);
        }
        carrinhoService.delete(id);
        return "Carrinho deletado com sucesso, Id: " + id;
    }
    
    @PostMapping("/carrinho/{userId}/aluguel/{aluguelId}")
    public String addAluguelToCarrinho(@PathVariable Long userId, @PathVariable Long aluguelId) {
        try {
            carrinhoService.addAluguelToCarrinho(userId, aluguelId);
            return "Aluguel adicionado ao carrinho com sucesso.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

}
