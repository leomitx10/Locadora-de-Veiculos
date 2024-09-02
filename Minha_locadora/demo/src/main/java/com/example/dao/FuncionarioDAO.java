package com.example.dao;

import java.util.List;
import com.example.demo.Funcionario;

public interface FuncionarioDAO {

    List<Funcionario> get();

    Funcionario get(int id);

    void save(Funcionario funcionario);

    void delete(int id);
}