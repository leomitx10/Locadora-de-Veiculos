package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;

public interface ApoliceService {
    List<ApoliceSeguro> get();
    
    ApoliceSeguro get(int id);
    
    void save(ApoliceSeguro apolice);
    
    void delete(int id);
}
