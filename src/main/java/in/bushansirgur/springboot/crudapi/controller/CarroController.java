package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.bushansirgur.springboot.crudapi.model.Carro;
import in.bushansirgur.springboot.crudapi.service.CarroService;

@RestController
@RequestMapping("/api")
public class CarroController {

    @Autowired
    private CarroService carroService;
    
    @PostMapping("/carros")
    public Carro save(@RequestBody Carro carro) {
        carroService.save(carro);
        return carro;
    }
    
    @GetMapping("/carros")
    public List<Carro> get() {
        return carroService.get();
    }
    
    @GetMapping("/carros/{id}")
    public Carro get(@PathVariable int id) {
        Carro carro = carroService.get(id);
        if (carro == null) {
            throw new RuntimeException("Carro não encontrado para o Id: " + id);
        }
        return carro;
    }
    
    @PutMapping("/carros")
    public Carro update(@RequestBody Carro carro) {
        carroService.save(carro);
        return carro;
    }
    
    @DeleteMapping("/carros/{id}")
    public String delete(@PathVariable int id) {
        carroService.delete(id);
        return "Carro deletado com sucesso, Id: " + id;
    }
}
