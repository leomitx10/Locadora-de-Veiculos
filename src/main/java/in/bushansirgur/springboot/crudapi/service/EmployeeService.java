package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Pessoa;

public interface EmployeeService {
	
	List<Pessoa> get();
	
	Pessoa get(int id);
	
	void save(Pessoa employee);
	
	void delete(int id); 
}
