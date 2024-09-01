package com.squad2.LocadoraDeVeiculos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping("/fabricante")
    public Fabricante save(@RequestBody Fabricante fabricante) {
        fabricanteService.save(fabricante);
        return fabricante;
    }

    @GetMapping("/fabricante")
    public List<Fabricante> get() {
        return fabricanteService.get();
    }

    @GetMapping("/fabricante/{id}")
    public Fabricante get(@PathVariable Long id) {
        Fabricante fabricante = fabricanteService.get(id);
        if (fabricante == null) {
            throw new RuntimeException("Fabricante not found for the Id: " + id);
        }
        return fabricante;
    }

    @PutMapping("/fabricante")
    public Fabricante update(@RequestBody Fabricante fabricante) {
        fabricanteService.save(fabricante);
        return fabricante;
    }

    @DeleteMapping("/fabricante/{id}")
    public String delete(@PathVariable Long id) {
        fabricanteService.delete(id);
        return "Fabricante has been deleted with id: " + id;
    }
}