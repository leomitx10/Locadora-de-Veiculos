package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.Carro;

public interface CarroDAO {
    
    List<Carro> get();
    
    Carro get(int id);
    
    void save(Carro carro);
    
    void delete(int id); 
}
