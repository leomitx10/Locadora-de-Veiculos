package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Funcionario;
import com.example.service.FuncionarioService;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;
    
    @PostMapping("/funcionario")
    public Funcionario save(@RequestBody Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return funcionario;
    }
    
    @GetMapping("/funcionario")
    public List<Funcionario> get() {
        return funcionarioService.get();
    }
    
    @GetMapping("/funcionario/{id}")
    public Funcionario get(@PathVariable int id) {
        Funcionario funcionario = funcionarioService.get(id);
        if (funcionario == null) {
            throw new RuntimeException("Funcionario nao encontrado para o Id: " + id);
        }
        return funcionario;
    }
    
    @PutMapping("/funcionario")
    public Funcionario update(@RequestBody Funcionario funcionario) {
        funcionarioService.save(funcionario);
        return funcionario;
    }
    
    @DeleteMapping("/funcionarios/{id}")
    public String delete(@PathVariable int id) {
        funcionarioService.delete(id);
        return "Funcionario deletado com sucesso, Id: " + id;
    }
}
