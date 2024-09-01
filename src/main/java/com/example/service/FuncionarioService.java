package com.example.service;

import java.util.List;

import com.example.dto.FuncionarioDTO;

public interface FuncionarioService {
    List<FuncionarioDTO> get();
    
    FuncionarioDTO get(int id);
    
    FuncionarioDTO save(FuncionarioDTO funcionarioDTO);
    
    void delete(int id);
}
