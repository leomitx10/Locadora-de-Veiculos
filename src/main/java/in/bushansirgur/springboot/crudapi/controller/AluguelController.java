package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.bushansirgur.springboot.crudapi.model.Aluguel;
import in.bushansirgur.springboot.crudapi.service.AluguelService;

@RestController
@RequestMapping("/api")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/aluguel")
    public ResponseEntity<Aluguel> save(@RequestBody Aluguel aluguel) {
        aluguelService.save(aluguel);
        return new ResponseEntity<>(aluguel, HttpStatus.CREATED);
    }

    @GetMapping("/aluguel")
    public ResponseEntity<List<Aluguel>> get() {
        List<Aluguel> alugueis = aluguelService.get();
        return new ResponseEntity<>(alugueis, HttpStatus.OK);
    }

    @GetMapping("/aluguel/{id}")
    public ResponseEntity<Aluguel> get(@PathVariable int id) {
        Aluguel aluguel = aluguelService.get(id);
        if (aluguel == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(aluguel, HttpStatus.OK);
    }

    @PutMapping("/aluguel")
    public ResponseEntity<Aluguel> update(@RequestBody Aluguel aluguel) {
        aluguelService.save(aluguel);
        return new ResponseEntity<>(aluguel, HttpStatus.OK);
    }

    @DeleteMapping("/aluguel/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        aluguelService.delete(id);
        return new ResponseEntity<>("Aluguel has been deleted with id:" + id, HttpStatus.OK);
    }
}
