package in.bushansirgur.springboot.crudapi.controller;

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

import in.bushansirgur.springboot.crudapi.dto.AluguelDTO;
import in.bushansirgur.springboot.crudapi.service.AluguelService;

@RestController
@RequestMapping("/api")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping("/aluguel")
    public AluguelDTO save(@RequestBody AluguelDTO aluguel) {
        aluguelService.save(aluguel);
        return aluguel;
    }

    @GetMapping("/aluguel")
    public List<AluguelDTO> get() {
        return aluguelService.get();
    }

    @GetMapping("/aluguel/{id}")
    public AluguelDTO get(@PathVariable int id) {
        AluguelDTO aluguel = aluguelService.get(id);
        if (aluguel == null) {
            throw new RuntimeException("Aluguel não encontrado para o ID: " + id);
        }
        return aluguel;
    }

    @GetMapping("/aluguel/user/{userId}")
    public List<AluguelDTO> getByUserId(@PathVariable Long userId) {
        return aluguelService.getByUserId(userId);
    }

    @PutMapping("/aluguel")
    public AluguelDTO update(@RequestBody AluguelDTO aluguel) {
        aluguelService.save(aluguel);
        return aluguel;
    }

    @DeleteMapping("/aluguel/{id}")
    public String delete(@PathVariable int id) {
        aluguelService.delete(id);
        return "Aluguel foi deletado com id: " + id;
    }
}
