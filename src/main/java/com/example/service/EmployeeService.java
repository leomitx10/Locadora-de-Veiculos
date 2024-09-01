package com.example.service;

import java.util.List;

import com.example.dto.PessoaDTO;

public interface EmployeeService {
    
    List<PessoaDTO> getAll();
    
    PessoaDTO get(int id);
    
    void save(PessoaDTO pessoaDTO);
    
    void delete(int id); 
}
