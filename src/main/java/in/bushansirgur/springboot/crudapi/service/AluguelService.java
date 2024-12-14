package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.model.Aluguel;

public interface AluguelService {
	
	List<Aluguel> get();
	
	Aluguel get(int id);
	
	void save(Aluguel aluguel);
	
	void delete(int id); 
}
