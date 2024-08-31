package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Pessoa;

public interface EmployeeDAO {
	
	List<Pessoa> getAll();
	
	Pessoa get(int id);
	
	void save(Pessoa pessoa);
	
	void delete(int id);
}
