package com.example.controller;

import com.example.demo.Fabricante;
import com.example.repository.FabricanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    // Criar um novo fabricante
    @PostMapping
    public ResponseEntity<Fabricante> createFabricante(@RequestBody Fabricante fabricante) {
        try {
            Fabricante savedFabricante = fabricanteRepository.save(fabricante);
            return new ResponseEntity<>(savedFabricante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obter todos os fabricantes
    @GetMapping
    public ResponseEntity<List<Fabricante>> getAllFabricantes() {
        try {
            List<Fabricante> fabricantes = fabricanteRepository.findAll();
            if (fabricantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(fabricantes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obter um fabricante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> getFabricanteById(@PathVariable("id") Long id) {
        Optional<Fabricante> fabricanteData = fabricanteRepository.findById(id);
        return fabricanteData.map(fabricante -> new ResponseEntity<>(fabricante, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar um fabricante
    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> updateFabricante(@PathVariable("id") Long id, @RequestBody Fabricante fabricante) {
        Optional<Fabricante> fabricanteData = fabricanteRepository.findById(id);
        if (fabricanteData.isPresent()) {
            Fabricante existingFabricante = fabricanteData.get();
            existingFabricante.setNome(fabricante.getNome());
            // Atualize outros campos conforme necessário
            return new ResponseEntity<>(fabricanteRepository.save(existingFabricante), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Deletar um fabricante
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteFabricante(@PathVariable("id") Long id) {
        try {
            fabricanteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
