package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import in.bushansirgur.springboot.crudapi.dto.ApoliceSeguroDTO;

public interface ApoliceService {
    List<ApoliceSeguroDTO> get();
    
    ApoliceSeguroDTO get(int id);
    
    void save(ApoliceSeguroDTO ApoliceSeguroDTO);
    
    void delete(int id);
}
