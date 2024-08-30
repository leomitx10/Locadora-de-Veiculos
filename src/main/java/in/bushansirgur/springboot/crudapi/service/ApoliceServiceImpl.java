package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import in.bushansirgur.springboot.crudapi.dao.ApoliceDAO;
import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceDAO apoliceDAO;

    @Transactional
    @Override
    public List<ApoliceSeguro> get() {
        return apoliceDAO.get();
    }

    @Transactional
    @Override
    public ApoliceSeguro get(int id) {
        return apoliceDAO.get(id);
    }

    @Transactional
    @Override
    public void save(ApoliceSeguro apolice) {
        apoliceDAO.save(apolice);
    }

    @Transactional
    @Override
    public void delete(int id) {
        apoliceDAO.delete(id);
    }
}
