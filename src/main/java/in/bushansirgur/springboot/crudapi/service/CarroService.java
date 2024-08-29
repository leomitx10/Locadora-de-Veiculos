package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Carro;

public interface CarroService {
	
	List<Carro> get();
	
	Carro get(int id);
	
	void save(Carro carro);
	
	void delete(int id); 
	
}
