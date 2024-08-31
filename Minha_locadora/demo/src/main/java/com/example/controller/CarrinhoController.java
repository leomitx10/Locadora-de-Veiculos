package com.example.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Carrinho;
import com.example.demo.Carro;
import com.example.service.CarrinhoService;

@RestController
@RequestMapping("/api")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/carrinho")
    public Carrinho addCarroToCarrinho(@RequestBody Carro carro, @RequestParam Long userId, @RequestParam String dataEntrega, @RequestParam String dataDevolucao) {
        return carrinhoService.addCarroToCarrinho(carro, userId, dataEntrega, dataDevolucao);
    }

    @GetMapping("/carrinho/{userId}")
    public Carrinho getCarrinho(@PathVariable Long userId) {
        return carrinhoService.getCarrinho(userId);
    }

    @PutMapping("/carrinho")
    public Carrinho updateCarrinho(@RequestBody Carrinho carrinho) {
        return carrinhoService.updateCarrinho(carrinho);
    }

    @PostMapping("/carrinho/confirmar")
    public String confirmarReserva(@RequestParam Long userId) {
        return carrinhoService.confirmarReserva(userId);
    }
}
