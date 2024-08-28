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

import in.bushansirgur.springboot.crudapi.model.Motorista;
import in.bushansirgur.springboot.crudapi.service.MotoristaService;

@RestController
@RequestMapping("/api")
public class MotoristaController {
	
	@Autowired
	private MotoristaService motoristaService;
	
	@PostMapping("/motorista")
	public Motorista save(@RequestBody Motorista employeeObj) {
		motoristaService.save(employeeObj);
		return employeeObj;
	}
	
	@GetMapping("/motorista")
	public List<Motorista> get(){
		return motoristaService.get();
	}
	
	@GetMapping("/motorista/{id}")
	public Motorista get(@PathVariable int id) {
		Motorista employeeObj = motoristaService.get(id);
		if(employeeObj == null) {
			throw new RuntimeException("Employee not found for the Id:"+id);
		}
		return employeeObj;
	}
	
	@PutMapping("/motorista")
	public Motorista update(@RequestBody Motorista employeeObj) {
		motoristaService.save(employeeObj);
		return employeeObj;
	}
	
	@DeleteMapping("/motorista/{id}")
	public String delete(@PathVariable int id) {
		motoristaService.delete(id);
		return "Employee has been deleted with id:"+id;
	}
}
