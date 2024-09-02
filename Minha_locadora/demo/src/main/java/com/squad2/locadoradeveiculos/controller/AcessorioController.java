package com.squad2.locadoradeveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.squad2.locadoradeveiculos.model.Acessorio;
import com.squad2.locadoradeveiculos.service.AcessorioService;

@RestController
@RequestMapping("/api")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;
    
    @PostMapping("/acessorios")
    public Acessorio save(@RequestBody Acessorio acessorio) {
        acessorioService.save(acessorio);
        return acessorio;
    }
    
    @GetMapping("/acessorios")
    public List<Acessorio> get() {
        return acessorioService.get();
    }
    
    @GetMapping("/acessorios/{id}")
    public Acessorio get(@PathVariable int id) {
        Acessorio acessorio = acessorioService.get(id);
        if (acessorio == null) {
            throw new RuntimeException("Acessório não encontrado para o Id: " + id);
        }
        return acessorio;
    }
    
    @PutMapping("/acessorios")
    public Acessorio update(@RequestBody Acessorio acessorio) {
        acessorioService.save(acessorio);
        return acessorio;
    }
    
    @DeleteMapping("/acessorios/{id}")
    public String delete(@PathVariable int id) {
        acessorioService.delete(id);
        return "Acessório deletado com sucesso, Id: " + id;
    }
}
