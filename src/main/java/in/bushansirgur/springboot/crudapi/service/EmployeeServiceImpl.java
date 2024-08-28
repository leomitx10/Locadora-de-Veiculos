package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.EmployeeDAO;
import in.bushansirgur.springboot.crudapi.model.Pessoa;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO; 
	
	@Transactional
	@Override
	public List<Pessoa> get() {
		return employeeDAO.get();
	}

	@Transactional
	@Override
	public Pessoa get(int id) {
		return employeeDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Pessoa employee) {
		employeeDAO.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		employeeDAO.delete(id);
	}

}
