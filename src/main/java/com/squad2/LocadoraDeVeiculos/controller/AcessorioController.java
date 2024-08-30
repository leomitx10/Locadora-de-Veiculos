package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Acessorio;
import com.squad2.LocadoraDeVeiculos.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody Acessorio acessorio) {
        String mensagem = acessorioService.salvar(acessorio);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<Acessorio>> listar() {
        List<Acessorio> acessorios = acessorioService.listar();
        return ResponseEntity.ok(acessorios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody Acessorio acessorio) {
        acessorio.setId(id);
        String mensagem = acessorioService.modificar(acessorio);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        String mensagem = acessorioService.deletar(id);
        return ResponseEntity.ok(mensagem);
    }
}

/*CRUD
http://localhost:8080/acessorios
{
    "descricao": "navegador GPS"
}
 */
