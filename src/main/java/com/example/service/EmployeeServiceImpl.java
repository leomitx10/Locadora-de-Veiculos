package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.EmployeeDAO;
import com.example.dto.FuncionarioDTO;
import com.example.dto.MotoristaDTO;
import com.example.dto.PessoaDTO;
import com.example.mapper.PessoaMapper;
import com.example.model.Funcionario;
import com.example.model.Motorista;
import com.example.model.Pessoa;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO; 
    
    @Transactional
    @Override
    public List<PessoaDTO> getAll() {
        List<Pessoa> pessoas = employeeDAO.getAll();
        return pessoas.stream()
                      .map(PessoaMapper::toDTO)
                      .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public PessoaDTO get(int id) {
        Pessoa pessoa = employeeDAO.get(id);
        return PessoaMapper.toDTO(pessoa);
    }

    @Transactional
    @Override
    public void save(PessoaDTO pessoaDTO) {
        Class<? extends Pessoa> pessoaClass = getPessoaClass(pessoaDTO);
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO, pessoaClass);
        employeeDAO.save(pessoa);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

     private Class<? extends Pessoa> getPessoaClass(PessoaDTO pessoaDTO) {
        if (pessoaDTO instanceof FuncionarioDTO) {
            return Funcionario.class;
        } else if (pessoaDTO instanceof MotoristaDTO) {
            return Motorista.class;
        } else {
            throw new IllegalArgumentException("Unknown DTO type: " + pessoaDTO.getClass().getName());
        }
    }
}
