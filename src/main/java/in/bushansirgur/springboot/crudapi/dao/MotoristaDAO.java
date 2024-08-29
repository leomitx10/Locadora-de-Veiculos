package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.Motorista;

public interface MotoristaDAO {
    List<Motorista> get();
    Motorista get(int id);
    void save(Motorista motorista);
    void delete(int id);
    List<Motorista> findByUserId(Long userId); 
}

