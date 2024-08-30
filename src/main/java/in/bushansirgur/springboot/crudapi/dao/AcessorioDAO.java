package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.Acessorio;

public interface AcessorioDAO {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id);
}
