package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.MotoristaDTO;

public interface MotoristaService {
    List<MotoristaDTO> get();
    
    MotoristaDTO get(int id);
    
    void save(MotoristaDTO motoristaDTO);
    
    void delete(int id);

    List<MotoristaDTO> getMotoristasByUserId(Long userId); 
}
