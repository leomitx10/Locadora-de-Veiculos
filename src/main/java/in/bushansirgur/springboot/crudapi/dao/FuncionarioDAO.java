package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Funcionario;

public interface FuncionarioDAO {
	List<Funcionario> get();
    
    Funcionario get(int id);
    
    Funcionario  save(Funcionario funcionario);
    
    void delete(int id); 
}
