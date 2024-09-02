package com.squad2.locadoradeveiculos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.squad2.locadoradeveiculos.dao.FuncionarioDAO;
import com.squad2.locadoradeveiculos.model.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Override
    public List<Funcionario> get() {
        return funcionarioDAO.get();
    }

    @Override
    public Funcionario get(int id) {
        return funcionarioDAO.get(id);
    }

    @Override
    public void save(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    @Override
    public void delete(int id) {
        funcionarioDAO.delete(id);
    }
}
