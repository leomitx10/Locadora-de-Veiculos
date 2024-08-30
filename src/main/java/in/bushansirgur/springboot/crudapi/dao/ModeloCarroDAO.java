package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.ModeloCarro;

public interface ModeloCarroDAO {
    void save(ModeloCarro modeloCarro);
    List<ModeloCarro> getAll();
    ModeloCarro getById(Long id);
    void update(ModeloCarro modeloCarro);
    void delete(Long id);
}
