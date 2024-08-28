package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.MotoristaDAO;
import in.bushansirgur.springboot.crudapi.model.Motorista;

@Service
public class MotoristaServiceImpl implements MotoristaService{

	@Autowired
	private MotoristaDAO motoristaDAO; 
	
	@Transactional
	@Override
	public List<Motorista> get() {
		return motoristaDAO.get();
	}

	@Transactional
	@Override
	public Motorista get(int id) {
		return motoristaDAO.get(id);
	}

	@Transactional
	@Override
	public void save(Motorista employee) {
		motoristaDAO.save(employee);
	}

	@Transactional
	@Override
	public void delete(int id) {
		motoristaDAO.delete(id);
	}
}
