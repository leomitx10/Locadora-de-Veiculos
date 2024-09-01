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

import com.example.dto.FuncionarioDTO;
import com.example.service.FuncionarioService;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping("/funcionario")
    public FuncionarioDTO create(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.save(funcionarioDTO);
    }

    @GetMapping("/funcionario")
    public List<FuncionarioDTO> getAll() {
        return funcionarioService.get();
    }

    @GetMapping("/funcionario/{id}")
    public FuncionarioDTO getById(@PathVariable int id) {
        return funcionarioService.get(id);
    }

    @PutMapping("/funcionario/{id}")
    public FuncionarioDTO update(@PathVariable int id, @RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioDTO.setId(id);
        return funcionarioService.save(funcionarioDTO);
    }

    @DeleteMapping("/funcionario/{id}")
    public String delete(@PathVariable int id) {
        funcionarioService.delete(id);
        return "Employee has been deleted with id:" + id;
    }
}
