package in.bushansirgur.springboot.crudapi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.bushansirgur.springboot.crudapi.model.Pessoa;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Pessoa> getAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Pessoa> query = currentSession.createQuery("from Pessoa", Pessoa.class);
		return query.getResultList();
	}

	@Override
	public Pessoa get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Pessoa pessoa = currentSession.get(Pessoa.class, id);
		if (pessoa == null) {
			throw new RuntimeException("Pessoa not found for ID: " + id);
		}
		return pessoa;
	}

	@Override
	public void save(Pessoa pessoa) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(pessoa);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Pessoa pessoa = currentSession.get(Pessoa.class, id);
		if (pessoa != null) {
			currentSession.delete(pessoa);
		} else {
			throw new RuntimeException("Pessoa not found for ID: " + id);
		}
	}
}
