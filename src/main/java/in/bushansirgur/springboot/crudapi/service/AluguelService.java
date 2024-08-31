package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.AluguelDTO;

public interface AluguelService {
    List<AluguelDTO> get();
    
    AluguelDTO get(int id);
    
    void save(AluguelDTO aluguelDTO);
    
    void delete(int id);
    
    List<AluguelDTO> getByUserId(Long userId); 
}
