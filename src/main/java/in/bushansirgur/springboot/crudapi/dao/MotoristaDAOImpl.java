package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import in.bushansirgur.springboot.crudapi.model.Motorista;

@Repository
public class MotoristaDAOImpl implements MotoristaDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Motorista> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Motorista> query = currentSession.createQuery("from Motorista", Motorista.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Motorista get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Motorista.class, id);
    }

    @Override
    @Transactional
    public void save(Motorista motorista) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(motorista);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Motorista motorista = currentSession.get(Motorista.class, id);
        currentSession.delete(motorista);
    }

    @Override
    @Transactional
    public List<Motorista> findByUserId(Long userId) { 
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Motorista> query = currentSession.createQuery("from Motorista where user.id = :userId", Motorista.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
