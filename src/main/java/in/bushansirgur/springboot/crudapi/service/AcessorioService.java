package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import in.bushansirgur.springboot.crudapi.model.Acessorio;

public interface AcessorioService {

    List<Acessorio> get();

    Acessorio get(int id);

    void save(Acessorio acessorio);

    void delete(int id); 
}

