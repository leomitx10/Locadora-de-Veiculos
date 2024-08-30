package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.crudapi.model.Aluguel;

@Repository
public class AluguelDAOimpl implements AluguelDAO { 

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Aluguel> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Aluguel> query = currentSession.createQuery("from Aluguel", Aluguel.class); 
        List<Aluguel> list = query.getResultList();
        return list;
    }

    @Override
    public Aluguel get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Aluguel aluguelObj = currentSession.get(Aluguel.class, id); 
        return aluguelObj;
    }

    @Override
    public void save(Aluguel aluguel) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(aluguel); 
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Aluguel aluguelObj = currentSession.get(Aluguel.class, id); 
        if (aluguelObj != null) {
            currentSession.delete(aluguelObj);
        }
    }
}
