package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.PessoaDTO;

public interface EmployeeService {
    
    List<PessoaDTO> getAll();
    
    PessoaDTO get(int id);
    
    void save(PessoaDTO pessoaDTO);
    
    void delete(int id); 
}
