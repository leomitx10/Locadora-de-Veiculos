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

    @GetMapping
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

    @PostMapping("/reset-id")
    public ResponseEntity<String> resetarIdCarro(){
        carroService.resetarIdCarro();
        return ResponseEntity.ok("Sequência de ID resetada para 1.");
    }

}
/*CRUD
http://localhost:8080/carros
{
    "placa": "ABC1234",
    "chassi": "9BWZZZ377VT004251",
    "cor": "Preto",
    "valorDiaria": 150.00
}
 */