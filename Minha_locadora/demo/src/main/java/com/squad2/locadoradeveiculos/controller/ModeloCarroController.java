package com.squad2.locadoradeveiculos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.squad2.locadoradeveiculos.model.ModeloCarro;
import com.squad2.locadoradeveiculos.service.ModeloCarroService;

@RestController
@RequestMapping("/api")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;

    @PostMapping("/modelo-carro")
    public ResponseEntity<String> save(@RequestBody ModeloCarro modeloCarro) {
        modeloCarroService.save(modeloCarro);
        return new ResponseEntity<>("Modelo de carro salvo com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping("/modelo-carro")
    public ResponseEntity<List<ModeloCarro>> getAll() {
        List<ModeloCarro> modelosCarro = modeloCarroService.getAll();
        if (modelosCarro.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(modelosCarro, HttpStatus.OK);
    }

    @GetMapping("/modelo-carro/{id}")
    public ResponseEntity<ModeloCarro> getById(@PathVariable Long id) {
        ModeloCarro modeloCarro = modeloCarroService.getById(id);
        if (modeloCarro == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(modeloCarro, HttpStatus.OK);
    }

    @PutMapping("/modelo-carro")
    public ResponseEntity<String> update(@RequestBody ModeloCarro modeloCarro) {
        modeloCarroService.save(modeloCarro);
        return new ResponseEntity<>("Modelo de carro atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/modelo-carro/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ModeloCarro modeloCarro = modeloCarroService.getById(id);
        if (modeloCarro == null) {
            return new ResponseEntity<>("Modelo de carro nao encontrado para o Id: " + id, HttpStatus.NOT_FOUND);
        }
        modeloCarroService.delete(id);
        return new ResponseEntity<>("Modelo de carro deletado com sucesso!", HttpStatus.OK);
    }
}
