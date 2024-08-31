package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Carrinho;
import com.squad2.LocadoraDeVeiculos.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {


    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping
    public ResponseEntity<Carrinho> criarCarrinho() {
        Carrinho novoCarrinho = carrinhoService.criarCarrinho();
        return ResponseEntity.ok(novoCarrinho);
    }

    @PostMapping("/{carrinhoId}/carros/{carroId}")
    public ResponseEntity<String> adicionarCarro(@PathVariable Long carrinhoId, @PathVariable Long carroId) {
        String resposta = carrinhoService.adicionarCarroAoCarrinho(carrinhoId, carroId);
        return ResponseEntity.ok(resposta);
    }

    @DeleteMapping("/{carrinhoId}/carros/{carroId}")
    public ResponseEntity<String> removerCarro(@PathVariable Long carrinhoId, @PathVariable Long carroId) {
        String resposta = carrinhoService.removerCarroDoCarrinho(carrinhoId, carroId);
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/{carrinhoId}/alugueis/{aluguelId}")
    public ResponseEntity<String> adicionarAluguel(@PathVariable Long carrinhoId, @PathVariable Long aluguelId) {
        String resposta = carrinhoService.adicionarAluguelAoCarrinho(carrinhoId, aluguelId);
        return ResponseEntity.ok(resposta);
    }


    @DeleteMapping("/{carrinhoId}/alugueis/{aluguelId}")
    public ResponseEntity<String> removerAluguel(@PathVariable Long carrinhoId, @PathVariable Long aluguelId) {
        String resposta = carrinhoService.removerAluguelDoCarrinho(carrinhoId, aluguelId);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{carrinhoId}")
    public ResponseEntity<Carrinho> obterCarrinho(@PathVariable Long carrinhoId) {
        Carrinho carrinho = carrinhoService.obterCarrinhoPorId(carrinhoId);
        if (carrinho != null) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{carrinhoId}")
    public ResponseEntity<Carrinho> atualizarCarrinho(@PathVariable Long carrinhoId, @RequestBody Carrinho carrinhoAtualizado) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId).orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        carrinho.setCarros(carrinhoAtualizado.getCarros());
        carrinho.setAluguel(carrinhoAtualizado.getAluguel());
        Carrinho carrinhoSalvo = carrinhoRepository.save(carrinho);
        return ResponseEntity.ok(carrinhoSalvo);
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
/*CRUD
criar carrinho
http://localhost:8080/carrinho
POST

adicionar carro
http://localhost:8080/carrinho/carrinhoId/carros/{carroId}
POST

remover carro
DELETE
http://localhost:8080/carrinho/{carrinhoId}/carros/{carroId}

adicionar aluguel
http://localhost:8080/carrinho/carrinhoId/alugueis/{aluguelId}
POST


remover aluguel
DELETE
http://localhost:8080/carrinho/{carrinhoId}/alugueis/{aluguelId}

verificar carrinho
http://localhost:8080/carrinho/{carrinhoId}/detalhes
GET
 */