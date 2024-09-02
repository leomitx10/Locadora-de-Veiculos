package com.squad2.locadoradeveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.squad2.locadoradeveiculos.model.Carro;
import com.squad2.locadoradeveiculos.model.Categoria;
import com.squad2.locadoradeveiculos.service.CarroService;

@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/carro")
    public String save(@RequestBody Carro carro) {
        carroService.save(carro);
        return "Carro salvo com sucesso!";
    }

    @GetMapping("/carro")
    public List<Carro> get() {
        return carroService.get();
    }

    @GetMapping("/carro/{id}")
    public Carro get(@PathVariable Long id) {
        Carro carro = carroService.get(id);
        if (carro == null) {
            throw new RuntimeException("Carro nao encontrado para o Id: " + id);
        }
        return carro;
    }

    @PutMapping("/carro")
    public String update(@RequestBody Carro carro) {
        carroService.save(carro);
        return "Carro atualizado com sucesso!";
    }

    @DeleteMapping("/carro/{id}")
    public String delete(@PathVariable Long id) {
        carroService.delete(id);
        return "Carro deletado com sucesso, Id: " + id;
    }
    
    @GetMapping("/carro/categoria/{categoria}")
    public List<Carro> getByCategoria(@PathVariable Categoria categoria) {
        return carroService.getByCategoria(categoria);
    }
    
    @GetMapping("/carro/acessorio/{acessorio}")
    public List<Carro> getByAcessorio(@PathVariable String acessorio) {
        return carroService.getByAcessorio(acessorio);
    }
}
