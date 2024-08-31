package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Aluguel;

public interface AluguelDAO {
    List<Aluguel> get();
    
    Aluguel get(int id);
    
    void save(Aluguel aluguel);
    
    void delete(int id);
    
    List<Aluguel> getByUserId(Long userId);
}
