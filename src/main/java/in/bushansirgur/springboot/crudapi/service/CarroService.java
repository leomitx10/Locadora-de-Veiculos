package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.CarroDTO;

public interface CarroService {
	
	List<CarroDTO> get();
	
	CarroDTO get(int id);
	
	void save(CarroDTO carroDTO);
	
	void delete(int id); 
	
}
