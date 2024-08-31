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

import in.bushansirgur.springboot.crudapi.dto.PessoaDTO;
import in.bushansirgur.springboot.crudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class PessoaController {

    @Autowired
    private EmployeeService employeeService;
    
    @PostMapping("/employee")
    public PessoaDTO save(@RequestBody PessoaDTO pessoaDTO) {
        employeeService.save(pessoaDTO);
        return pessoaDTO;
    }
    
    @GetMapping("/employee")
    public List<PessoaDTO> get() {
        return employeeService.getAll();
    }
    
    @GetMapping("/employee/{id}")
    public PessoaDTO get(@PathVariable int id) {
        PessoaDTO pessoaDTO = employeeService.get(id);
        if (pessoaDTO == null) {
            throw new RuntimeException("Employee not found for the Id:" + id);
        }
        return pessoaDTO;
    }
    
    @PutMapping("/employee")
    public PessoaDTO update(@RequestBody PessoaDTO pessoaDTO) {
        employeeService.save(pessoaDTO);
        return pessoaDTO;
    }
    
    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id) {
        employeeService.delete(id);
        return "Employee has been deleted with id:" + id;
    }
}
