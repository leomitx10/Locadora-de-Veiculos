package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Pessoa;

public interface EmployeeDAO {
	
	List<Pessoa> get();
	
	Pessoa get(int id);
	
	void save(Pessoa employee);
	
	void delete(int id); 
}
