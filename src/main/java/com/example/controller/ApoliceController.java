package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ApoliceSeguroDTO;
import com.example.service.ApoliceService;

@RestController
@RequestMapping("/api")
public class ApoliceController {

    @Autowired
    private ApoliceService apoliceService;
    
    @PostMapping("/apolice")
    public ApoliceSeguroDTO save(@RequestBody ApoliceSeguroDTO apolice) {
        apoliceService.save(apolice);
        return apolice;
    }
    
    @GetMapping("/apolice")
    public List<ApoliceSeguroDTO> get() {
        return apoliceService.get();
    }
    
    @GetMapping("/apolice/{id}")
    public ApoliceSeguroDTO get(@PathVariable int id) {
        ApoliceSeguroDTO apolice = apoliceService.get(id);
        if (apolice == null) {
            throw new RuntimeException("Apolice not found for the Id: " + id);
        }
        return apolice;
    }
    
    @PutMapping("/apolice")
    public ApoliceSeguroDTO update(@RequestBody ApoliceSeguroDTO apolice) {
        apoliceService.save(apolice);
        return apolice;
    }
    
    @DeleteMapping("/apolice/{id}")
    public String delete(@PathVariable int id) {
        apoliceService.delete(id);
        return "Apolice has been deleted with id: " + id;
    }
}
