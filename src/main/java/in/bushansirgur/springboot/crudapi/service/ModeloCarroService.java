package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bushansirgur.springboot.crudapi.dao.ModeloCarroDAO;
import in.bushansirgur.springboot.crudapi.model.ModeloCarro;

@Service
public class ModeloCarroService {

    @Autowired
    private ModeloCarroDAO modeloCarroDAO;

    public void save(ModeloCarro modeloCarro) {
        modeloCarroDAO.save(modeloCarro);
    }

    public List<ModeloCarro> getAll() {
        return modeloCarroDAO.getAll();
    }

    public ModeloCarro getById(Long id) {
        return modeloCarroDAO.getById(id);
    }

    public void update(ModeloCarro modeloCarro) {
        modeloCarroDAO.update(modeloCarro);
    }

    public void delete(Long id) {
        modeloCarroDAO.delete(id);
    }
}
