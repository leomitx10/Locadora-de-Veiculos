package com.squad2.LocadoraDeVeiculos.controller;


import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.Carro;
import com.squad2.LocadoraDeVeiculos.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Carro carro) {
        String mensagem = carroService.salvar(carro);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Carro>> listar() {
        List<Carro> carros = carroService.listar();
        return ResponseEntity.ok(carros);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody Carro carro) {
        carro.setId(id);
        String mensagem = carroService.modificar(carro);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        String mensagem = carroService.deletar(id);
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/{carroId}/acessorios/{acessorioId}")
    public ResponseEntity<String> associarAcessorioAoCarro(
            @PathVariable Long carroId,
            @PathVariable Long acessorioId) {
        String mensagem = carroService.associarAcessorioAoCarro(carroId, acessorioId);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/{carroId}/acessorios/{acessorioId}")
    public ResponseEntity<String> desassociarAcessorioDoCarro(
            @PathVariable Long carroId,
            @PathVariable Long acessorioId) {
        String mensagem = carroService.desassociarAcessorioDoCarro(carroId, acessorioId);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping("/{carroId}/acessorios")
    public ResponseEntity<Carro> obterCarroComAcessorios(@PathVariable Long carroId) {
        Carro carro = carroService.obterCarroComAcessorios(carroId);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
/*CRUD
POST
http://localhost:8080/carros
{
    "placa": "ABC1234",
    "chassi": "9BWZZZ377VT004251",
    "cor": "Preto",
    "valorDiaria": 150.00
}
GET
http://localhost:8080/carros/{id}

PUT
http://localhost:8080/carros/{id}

DELETE
http://localhost:8080/carros/{id}

adicionar acessorio ao carro
POST
http://localhost:8080/carros/{carroId}/acessorios/{acessorioId}

desassociar acessorio de carro
DELETE
http://localhost:8080/carros/{carroId}/acessorios/{acessorioId}

carro com acessório
GET
http://localhost:8080/carros/{carroId}/acessorios

 */