package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.model.Funcionario;
import jakarta.persistence.EntityManager;

@Repository
public class FuncionarioDAOimpl implements FuncionarioDAO{
	
	@Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Funcionario> get() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Funcionario> query = currentSession.createQuery("from Funcionario", Funcionario.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Funcionario get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Funcionario.class, id);
    }

    @Override
    @Transactional
    public void save(Funcionario funcionario) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(funcionario);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Funcionario funcionario = currentSession.get(Funcionario.class, id);
        currentSession.delete(funcionario);
    }

}
