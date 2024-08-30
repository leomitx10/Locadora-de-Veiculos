package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.bushansirgur.springboot.crudapi.dao.CarroDAO;

import in.bushansirgur.springboot.crudapi.model.Carro;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroDAO carroDAO; 
    
    @Transactional
    @Override
    public List<Carro> get() {
        return carroDAO.get();
    }

    @Transactional
    @Override
    public Carro get(int id) {
        return carroDAO.get(id);
    }

    @Transactional
    @Override
    public void save(Carro carro) {
        carroDAO.save(carro);
    }

    @Transactional
    @Override
    public void delete(int id) {
        carroDAO.delete(id);
    }
    
}
