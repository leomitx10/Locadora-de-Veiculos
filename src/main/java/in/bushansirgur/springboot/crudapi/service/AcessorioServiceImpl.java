package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.bushansirgur.springboot.crudapi.dao.AcessorioDAO;
import in.bushansirgur.springboot.crudapi.model.Acessorio;

@Service
public class AcessorioServiceImpl implements AcessorioService {

    @Autowired
    private AcessorioDAO acessorioDAO;

    @Override
    public List<Acessorio> get() {
        return acessorioDAO.get();
    }

    @Override
    public Acessorio get(int id) {
        return acessorioDAO.get(id);
    }

    @Override
    public void save(Acessorio acessorio) {
        acessorioDAO.save(acessorio);
    }

    @Override
    public void delete(int id) {
        acessorioDAO.delete(id);
    }
}

