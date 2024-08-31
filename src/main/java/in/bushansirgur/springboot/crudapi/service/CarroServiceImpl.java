package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.CarroDAO;
import in.bushansirgur.springboot.crudapi.dto.CarroDTO;
import in.bushansirgur.springboot.crudapi.mapper.CarroMapper;
import in.bushansirgur.springboot.crudapi.model.Carro;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroDAO carroDAO; 
    
    @Transactional
    @Override
    public List<CarroDTO> get() {
        List<Carro> carros = carroDAO.get();
        return carros.stream()
                     .map(CarroMapper::toDTO)
                     .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CarroDTO get(int id) {
        Carro carro = carroDAO.get(id);
        return CarroMapper.toDTO(carro);
    }

    @Transactional
    @Override
    public void save(CarroDTO carroDTO) {
        Carro carro = CarroMapper.toEntity(carroDTO);
        carroDAO.save(carro);
    }

    @Transactional
    @Override
    public void delete(int id) {
        carroDAO.delete(id);
    }
}
