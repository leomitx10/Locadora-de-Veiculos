package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Funcionario;

public interface FuncionarioService {
List<Funcionario> get();
	
	Funcionario get(int id);
	
	void save(Funcionario funcionario);
	
	void delete(int id); 
}
