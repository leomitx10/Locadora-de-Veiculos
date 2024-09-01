package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Carrinho;
import com.squad2.LocadoraDeVeiculos.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Carrinho> criarCarrinho() {
        Carrinho novoCarrinho = carrinhoService.criarCarrinho();
        return ResponseEntity.ok(novoCarrinho);
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> obterTodosCarrinhos() {
        List<Carrinho> carrinhos = carrinhoService.obterTodosCarrinhos();
        return ResponseEntity.ok(carrinhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> obterCarrinhoPorId(@PathVariable Long id) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(id);
        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable Long id, @RequestBody Carrinho carrinhoAtualizado) {
        Carrinho carrinho = carrinhoService.atualizarCarrinho(id, carrinhoAtualizado);
        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCarrinho(@PathVariable Long id) {
        carrinhoService.deletarCarrinho(id);
        return ResponseEntity.ok("Carrinho deletado com sucesso.");
    }

    @PostMapping("/{carrinhoId}/carros/{carroId}")
    public ResponseEntity<String> adicionarCarroAoCarrinho(@PathVariable Long carrinhoId, @PathVariable Long carroId) {
        String resposta = carrinhoService.adicionarCarroAoCarrinho(carrinhoId, carroId);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{carrinhoId}/carros/{carroId}")
    public ResponseEntity<String> removerCarroDoCarrinho(@PathVariable Long carrinhoId, @PathVariable Long carroId) {
        String resposta = carrinhoService.removerCarroDoCarrinho(carrinhoId, carroId);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/{carrinhoId}/alugueis/{aluguelId}")
    public ResponseEntity<String> adicionarAluguelAoCarrinho(@PathVariable Long carrinhoId, @PathVariable Long aluguelId) {
        String resposta = carrinhoService.adicionarAluguelAoCarrinho(carrinhoId, aluguelId);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{carrinhoId}/alugueis/{aluguelId}")
    public ResponseEntity<String> removerAluguelDoCarrinho(@PathVariable Long carrinhoId, @PathVariable Long aluguelId) {
        String resposta = carrinhoService.removerAluguelDoCarrinho(carrinhoId, aluguelId);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{carrinhoId}/detalhes")
    public ResponseEntity<Carrinho> obterCarrinhoComDetalhes(@PathVariable Long carrinhoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoComDetalhes(carrinhoId);
        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}