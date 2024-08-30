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
	public List<Pessoa> get() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Pessoa> query = currentSession.createQuery("from Employee", Pessoa.class);
		List<Pessoa> list = query.getResultList();
		return list;
	}

	@Override
	public Pessoa get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Pessoa employeeObj = currentSession.get(Pessoa.class, id);
		return employeeObj;
	}

	@Override
	public void save(Pessoa employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Pessoa employeeObj = currentSession.get(Pessoa.class, id);
		currentSession.delete(employeeObj);
	}

}
