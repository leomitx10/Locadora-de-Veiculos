package com.squad2.locadoradeveiculos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.squad2.locadoradeveiculos.model.Aluguel;
import com.squad2.locadoradeveiculos.model.Carrinho;
import com.squad2.locadoradeveiculos.service.CarrinhoService;

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

    @GetMapping("/carrinho/{carrinhoId}")
    public List<Aluguel> getAlugueisByCarrinhoId(@PathVariable Long carrinhoId) {
        return carrinhoService.getAlugueisByCarrinhoId(carrinhoId);
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
    
    @PostMapping("/carrinho/{carrinhoId}/aluguel/{aluguelId}")
    public String addAluguelToCarrinho(@PathVariable Long carrinhoId, @PathVariable Long aluguelId) {
        try {
            carrinhoService.addAluguelToCarrinho(carrinhoId, aluguelId);
            return "Aluguel adicionado ao carrinho com sucesso.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
    
    @GetMapping("/carrinhos/{id}/resumo")
    public ResponseEntity<String> obterResumo(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.get(id);
        if (carrinho == null) {
            throw new RuntimeException("Carrinho não encontrado para o Id: " + id);
        }

        String resumo = carrinho.resumo();
        return ResponseEntity.ok(resumo);
    }

}
