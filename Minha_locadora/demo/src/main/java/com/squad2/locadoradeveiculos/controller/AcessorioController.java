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
    public String save(@RequestBody Acessorio acessorio) {
        acessorioService.save(acessorio);
        return "Acessorio salvo com sucesso!";
    }
    
    @GetMapping("/acessorios")
    public List<Acessorio> get() {
        return acessorioService.get();
    }
    
    @GetMapping("/acessorios/{id}")
    public Acessorio get(@PathVariable int id) {
        Acessorio acessorio = acessorioService.get(id);
        if (acessorio == null) {
            throw new RuntimeException("Acessorio nao encontrado para o Id: " + id);
        }
        return acessorio;
    }
    
    @PutMapping("/acessorios")
    public String update(@RequestBody Acessorio acessorio) {
        acessorioService.save(acessorio);
        return "Acessorio atualizado com sucesso!";
    }
    
    @DeleteMapping("/acessorios/{id}")
    public String delete(@PathVariable int id) {
        Acessorio acessorio = acessorioService.get(id);
        if (acessorio == null) {
            throw new RuntimeException("Acessorio nao encontrado para o Id: " + id);
        }
        acessorioService.delete(id);
        return "Acessorio deletado com sucesso, Id: " + id;
    }
}
