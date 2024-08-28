package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Motorista;

public interface MotoristaService {
	
List<Motorista> get();
	
	Motorista get(int id);
	
	void save(Motorista employee);
	
	void delete(int id); 

}
