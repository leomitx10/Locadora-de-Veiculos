package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;
import in.bushansirgur.springboot.crudapi.service.ApoliceService;

@RestController
@RequestMapping("/api")
public class ApoliceController {

    @Autowired
    private ApoliceService apoliceService;
    
    @PostMapping("/apolice")
    public ApoliceSeguro save(@RequestBody ApoliceSeguro apolice) {
        apoliceService.save(apolice);
        return apolice;
    }
    
    @GetMapping("/apolice")
    public List<ApoliceSeguro> get() {
        return apoliceService.get();
    }
    
    @GetMapping("/apolice/{id}")
    public ApoliceSeguro get(@PathVariable int id) {
        ApoliceSeguro apolice = apoliceService.get(id);
        if (apolice == null) {
            throw new RuntimeException("Apolice not found for the Id: " + id);
        }
        return apolice;
    }
    
    @PutMapping("/apolice")
    public ApoliceSeguro update(@RequestBody ApoliceSeguro apolice) {
        apoliceService.save(apolice);
        return apolice;
    }
    
    @DeleteMapping("/apolice/{id}")
    public String delete(@PathVariable int id) {
        apoliceService.delete(id);
        return "Apolice has been deleted with id: " + id;
    }
}
