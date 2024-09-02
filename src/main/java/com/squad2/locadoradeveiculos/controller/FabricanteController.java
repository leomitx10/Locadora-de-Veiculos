package com.squad2.locadoradeveiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.squad2.locadoradeveiculos.model.Fabricante;
import com.squad2.locadoradeveiculos.service.FabricanteService;

@RestController
@RequestMapping("/api")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping("/fabricante")
    public String save(@RequestBody Fabricante fabricante) {
        fabricanteService.save(fabricante);
        return "Fabricante salvo com sucesso.";
    }

    @GetMapping("/fabricante")
    public List<Fabricante> get() {
        return fabricanteService.get();
    }

    @GetMapping("/fabricante/{id}")
    public Fabricante get(@PathVariable Long id) {
        Fabricante fabricante = fabricanteService.get(id);
        if (fabricante == null) {
            throw new RuntimeException("Fabricante nao encontrado para o Id: " + id);
        }
        return fabricante;
    }

    @PutMapping("/fabricante")
    public String update(@RequestBody Fabricante fabricante) {
        fabricanteService.save(fabricante);
        return "Fabricante atualizado com sucesso.";
    }

    @DeleteMapping("/fabricante/{id}")
    public String delete(@PathVariable Long id) {
        Fabricante fabricante = fabricanteService.get(id);
        if (fabricante == null) {
            throw new RuntimeException("Fabricante nao encontrado para o Id: " + id);
        }
        fabricanteService.delete(id);
        return "Fabricante foi excluido com o Id: " + id;
    }
}
