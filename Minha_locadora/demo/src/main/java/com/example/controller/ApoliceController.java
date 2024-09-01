package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.ApoliceSeguro;
import com.example.service.ApoliceService;

@RestController
@RequestMapping("/api")
public class ApoliceController {

    @Autowired
    private ApoliceService apoliceService;

    @PostMapping("/apolice")
    public String save(@RequestBody ApoliceSeguro apolice) {
        apoliceService.save(apolice);
        return "Apolice cadastrada com sucesso";
    }

    @GetMapping("/apolice")
    public List<ApoliceSeguro> get() {
        return apoliceService.get();
    }

    @GetMapping("/apolice/{id}")
    public ApoliceSeguro get(@PathVariable Long id) {
        ApoliceSeguro apolice = apoliceService.get(id);
        if (apolice == null) {
            throw new RuntimeException("Apolice not found for the Id: " + id);
        }
        return apolice;
    }

    @PutMapping("/apolice")
    public ApoliceSeguro update(@RequestBody ApoliceSeguro apolice) {
        apoliceService.save(apolice);
        return apolice;
    }

    @DeleteMapping("/apolice/{id}")
    public String delete(@PathVariable Long id) {
        apoliceService.delete(id);
        return "Apolice has been deleted with id: " + id;
    }
}
