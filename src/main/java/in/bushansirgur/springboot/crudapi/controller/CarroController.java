package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.crudapi.dto.CarroDTO;
import in.bushansirgur.springboot.crudapi.service.CarroService;


@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/carro")
    public ResponseEntity<CarroDTO> save(@RequestBody CarroDTO carroDTO) {
        carroService.save(carroDTO);
        return new ResponseEntity<>(carroDTO, HttpStatus.CREATED);
    }

    @GetMapping("/carro")
    public ResponseEntity<List<CarroDTO>> get() {
        List<CarroDTO> carros = carroService.get();
        return new ResponseEntity<>(carros, HttpStatus.OK);
    }

    @GetMapping("/carro/{id}")
    public ResponseEntity<CarroDTO> get(@PathVariable int id) {
        CarroDTO carroDTO = carroService.get(id);
        if (carroDTO == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carroDTO, HttpStatus.OK);
    }

    @PutMapping("/carro")
    public ResponseEntity<CarroDTO> update(@RequestBody CarroDTO carroDTO) {
        carroService.save(carroDTO);
        return new ResponseEntity<>(carroDTO, HttpStatus.OK);
    }

    @DeleteMapping("/carro/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        carroService.delete(id);
        return new ResponseEntity<>("Carro has been deleted with id:" + id, HttpStatus.OK);
    }
}
