package com.example.dao;

import java.util.List;

import com.example.model.Funcionario;

public interface FuncionarioDAO {
	List<Funcionario> get();
    
    Funcionario get(int id);
    
    Funcionario  save(Funcionario funcionario);
    
    void delete(int id); 
}
