package com.squad2.LocadoraDeVeiculos.controller;

import com.squad2.LocadoraDeVeiculos.model.entity.Aluguel;
import com.squad2.LocadoraDeVeiculos.model.entity.ApoliceSeguro;
import com.squad2.LocadoraDeVeiculos.service.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alugueis/apolice")
public class ApoliceSeguroController {

    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @PostMapping
    public ResponseEntity<String> salvar(@RequestBody ApoliceSeguro apoliceSeguro) {
        String mensagem = apoliceSeguroService.salvar(apoliceSeguro);
        return ResponseEntity.ok(mensagem);
    }

    @GetMapping
    public ResponseEntity<List<ApoliceSeguro>> listar() {
        List<ApoliceSeguro> apolice = apoliceSeguroService.listar();
        return ResponseEntity.ok(apolice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> modificar(@PathVariable Long id, @RequestBody ApoliceSeguro apoliceSeguro) {
        apoliceSeguro.setId(id);
        String mensagem = apoliceSeguroService.modificar(apoliceSeguro);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletar(@PathVariable("id") Long id) {
        String mensagem = apoliceSeguroService.deletar(id);
        return ResponseEntity.ok(mensagem);
    }

    @PostMapping("/reset-id")
    public ResponseEntity<String> resetarIdApoliceSeguro(){
        apoliceSeguroService.resetarIdApoliceSeguro();
        return ResponseEntity.ok("Sequência de ID resetada para 1.");
    }
}
/*CRUD
http://localhost:8080/alugueis/apolice
{
  "valorFranquia": 300.00,
  "protecaoTerceiro": true,
  "protecaoCausasNaturais": false,
  "protecaoRoubo": false
}
 */
