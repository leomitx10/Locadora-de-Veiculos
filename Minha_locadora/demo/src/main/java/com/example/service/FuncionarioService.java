package com.example.service;

import java.util.List;
import com.example.demo.Funcionario;

public interface FuncionarioService {

    List<Funcionario> get();

    Funcionario get(int id);

    void save(Funcionario funcionario);

    void delete(int id); 
}

