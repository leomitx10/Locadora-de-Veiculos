package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;

public interface ApoliceDAO {
    List<ApoliceSeguro> get();
    
    ApoliceSeguro get(int id);
    
    void save(ApoliceSeguro apolice);
    
    void delete(int id); 
}
