package com.example.dao;

import java.util.List;

import com.example.model.Pessoa;

public interface EmployeeDAO {
	
	List<Pessoa> getAll();
	
	Pessoa get(int id);
	
	void save(Pessoa pessoa);
	
	void delete(int id);
}
