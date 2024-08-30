package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.FuncionarioDAO;
import in.bushansirgur.springboot.crudapi.model.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioDAO funcionarioDAO; 
    
    @Transactional
    @Override
    public List<Funcionario> get() {
        return funcionarioDAO.get();
    }

    @Transactional
    @Override
    public Funcionario get(int id) {
        return funcionarioDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Funcionario funcionario) {
        funcionarioDAO.save(funcionario);
    }

    @Transactional
    @Override
    public void delete(int id) {
        funcionarioDAO.delete(id);
    }
}
