package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Carro;
import com.example.service.CarroService;

@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/carro")
    public Carro save(@RequestBody Carro carro) {
        carroService.save(carro);
        return carro;
    }

    @GetMapping("/carro")
    public List<Carro> get() {
        return carroService.get();
    }

    @GetMapping("/carro/{id}")
    public Carro get(@PathVariable Long id) {
        Carro carro = carroService.get(id);
        if (carro == null) {
            throw new RuntimeException("Carro not found for the Id: " + id);
        }
        return carro;
    }

    @PutMapping("/carro")
    public Carro update(@RequestBody Carro carro) {
        carroService.save(carro);
        return carro;
    }

    @DeleteMapping("/carro/{id}")
    public String delete(@PathVariable Long id) {
        carroService.delete(id);
        return "Carro has been deleted with id: " + id;
    }
}
