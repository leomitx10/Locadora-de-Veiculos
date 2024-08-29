package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.bushansirgur.springboot.crudapi.dao.MotoristaDAO;
import in.bushansirgur.springboot.crudapi.model.Motorista;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    @Autowired
    private MotoristaDAO motoristaDAO;

    @Override
    public List<Motorista> get() {
        return motoristaDAO.get();
    }

    @Override
    public Motorista get(int id) {
        return motoristaDAO.get(id);
    }

    @Override
    public void save(Motorista motorista) {
        motoristaDAO.save(motorista);
    }

    @Override
    public void delete(int id) {
        motoristaDAO.delete(id);
    }

    @Override
    public List<Motorista> getMotoristasByUserId(Long userId) { // Alterado para Long
        return motoristaDAO.findByUserId(userId);
    }
}
