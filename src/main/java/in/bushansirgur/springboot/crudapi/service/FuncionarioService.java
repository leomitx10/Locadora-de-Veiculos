package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.FuncionarioDTO;

public interface FuncionarioService {
    List<FuncionarioDTO> get();
    
    FuncionarioDTO get(int id);
    
    FuncionarioDTO save(FuncionarioDTO funcionarioDTO);
    
    void delete(int id);
}
