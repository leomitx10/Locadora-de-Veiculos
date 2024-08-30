package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.bushansirgur.springboot.crudapi.model.ModeloCarro;
import in.bushansirgur.springboot.crudapi.service.ModeloCarroService;

@RestController
@RequestMapping("/api")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;

    @PostMapping("/modelo-carro")
    public ResponseEntity<ModeloCarro> save(@RequestBody ModeloCarro modeloCarro) {
        modeloCarroService.save(modeloCarro);
        return new ResponseEntity<>(modeloCarro, HttpStatus.CREATED);
    }

    @GetMapping("/modelo-carro")
    public ResponseEntity<List<ModeloCarro>> getAll() {
        List<ModeloCarro> modelosCarro = modeloCarroService.getAll();
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
    public ResponseEntity<ModeloCarro> update(@RequestBody ModeloCarro modeloCarro) {
        modeloCarroService.save(modeloCarro);
        return new ResponseEntity<>(modeloCarro, HttpStatus.OK);
    }

    @DeleteMapping("/modelo-carro/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        modeloCarroService.delete(id);
        return new ResponseEntity<>("Modelo de carro deletado com sucesso!", HttpStatus.OK);
    }
}
