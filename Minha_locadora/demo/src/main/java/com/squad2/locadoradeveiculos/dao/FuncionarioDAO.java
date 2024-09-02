package com.squad2.locadoradeveiculos.dao;

import java.util.List;

import com.squad2.locadoradeveiculos.model.Funcionario;

public interface FuncionarioDAO {

    List<Funcionario> get();

    Funcionario get(int id);

    void save(Funcionario funcionario);

    void delete(int id);
}