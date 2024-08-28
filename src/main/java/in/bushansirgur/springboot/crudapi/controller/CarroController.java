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

import in.bushansirgur.springboot.crudapi.model.Carro;
import in.bushansirgur.springboot.crudapi.service.CarroService;


@RestController
@RequestMapping("/api")
public class CarroController {

	@Autowired
	private CarroService carroService;
	
	@PostMapping("/carro")
	public Carro save(@RequestBody Carro employeeObj) {
		carroService.save(employeeObj);
		return employeeObj;
	}
	
	@GetMapping("/carro")
	public List<Carro> get(){
		return carroService.get();
	}
	
	@GetMapping("/carro/{id}")
	public Carro get(@PathVariable int id) {
		Carro employeeObj = carroService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found for the Id:"+id);
		}
		return employeeObj;
	}
	
	@PutMapping("/carro")
	public Carro update(@RequestBody Carro employeeObj) {
		carroService.save(employeeObj);
		return employeeObj;
	}
	
	@DeleteMapping("/carro/{id}")
	public String delete(@PathVariable int id) {
		carroService.delete(id);
		return "Employee has been deleted with id:"+id;
	}
}
