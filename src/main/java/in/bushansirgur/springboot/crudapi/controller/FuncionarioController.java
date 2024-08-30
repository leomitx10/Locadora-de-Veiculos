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

import in.bushansirgur.springboot.crudapi.model.Funcionario;
import in.bushansirgur.springboot.crudapi.service.FuncionarioService;

@RestController
@RequestMapping("/api")
public class FuncionarioController {
		
	@Autowired
	private FuncionarioService funcionarioService;
		
	@PostMapping("/funcionario")
	public Funcionario save(@RequestBody Funcionario employeeObj) {
		funcionarioService.save(employeeObj);
		return employeeObj;
	}
	
	@GetMapping("/funcionario")
	public List<Funcionario> get(){
		return funcionarioService.get();
	}
	
	@GetMapping("/funcionario/{id}")
	public Funcionario get(@PathVariable int id) {
		Funcionario employeeObj = funcionarioService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found for the Id:"+id);
		}
		return employeeObj;
	}
	
	@PutMapping("/funcionario")
	public Funcionario update(@RequestBody Funcionario employeeObj) {
		funcionarioService.save(employeeObj);
		return employeeObj;
	}
	
	@DeleteMapping("/funcionario{id}")
	public String delete(@PathVariable int id) {
		funcionarioService.delete(id);
		return "Employee has been deleted with id:"+id;
	}
}
