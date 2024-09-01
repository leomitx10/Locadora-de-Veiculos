package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Aluguel;
import com.example.service.AluguelService;

@RestController
@RequestMapping("/api")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/aluguel")
    public String save(@RequestBody Aluguel aluguel) {
        aluguelService.save(aluguel);
        return "Aluguel cadastrado com sucesso";
    }

    @GetMapping("/aluguel")
    public List<Aluguel> get() {
        return aluguelService.get();
    }

    @GetMapping("/aluguel/{id}")
    public Aluguel get(@PathVariable int id) {
        Aluguel aluguel = aluguelService.get(id);
        if (aluguel == null) {
            throw new RuntimeException("Aluguel não encontrado para o ID: " + id);
        }
        return aluguel;
    }

    @GetMapping("/aluguel/user/{userId}")
    public List<Aluguel> getByUserId(@PathVariable Long userId) {
        return aluguelService.getByUserId(userId);
    }

    @PutMapping("/aluguel")
    public Aluguel update(@RequestBody Aluguel aluguel) {
        aluguelService.save(aluguel);
        return aluguel;
    }

    @DeleteMapping("/aluguel/{id}")
    public String delete(@PathVariable int id) {
        aluguelService.delete(id);
        return "Aluguel foi deletado com id: " + id;
    }
}
