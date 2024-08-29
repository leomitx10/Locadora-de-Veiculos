package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.crudapi.model.Carro;

@Repository
public class CarroDAOImpl implements CarroDAO {
    
    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Carro> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Carro> query = currentSession.createQuery("from Carro", Carro.class);
        return query.getResultList();
    }

    @Override
    public Carro get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Carro.class, id);
    }

    @Override
    public void save(Carro carro) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(carro);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Carro carro = currentSession.get(Carro.class, id);
        if (carro != null) {
            currentSession.delete(carro);
        }
    }
}
