package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {


    @Autowired
    private AluguelService aluguelService;


    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Aluguel aluguel) {
        String mensagem = aluguelService.salvar(aluguel);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<Aluguel>> listar() {
        List<Aluguel> alugueis = aluguelService.listar();
        return ResponseEntity.ok(alugueis);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody Aluguel aluguel) {
        aluguel.setId(id);
        String mensagem = aluguelService.modificar(aluguel);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        String mensagem = aluguelService.deletar(id);
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/reset-id")
    public ResponseEntity<String> resetarIdAluguel(){
        aluguelService.resetarIdAluguel();
        return ResponseEntity.ok("Sequência de ID resetada para 1.");
    }
}

/*CRUD
http://localhost:8080/alugueis
{
  "dataPedido": "2024-08-01",
  "dataEntrega": "2024-08-05",
  "dataDevolucao": "2024-08-10"
  }
 */