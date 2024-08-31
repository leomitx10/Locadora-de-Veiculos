package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.MotoristaDAO;
import in.bushansirgur.springboot.crudapi.dto.MotoristaDTO;
import in.bushansirgur.springboot.crudapi.mapper.MotoristaMapper;
import in.bushansirgur.springboot.crudapi.model.Motorista;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    @Autowired
    private MotoristaDAO motoristaDAO;

    @Transactional
    @Override
    public List<MotoristaDTO> get() {
        List<Motorista> motoristas = motoristaDAO.get();
        return motoristas.stream()
                         .map(MotoristaMapper::toDTO)
                         .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public MotoristaDTO get(int id) {
        Motorista motorista = motoristaDAO.get(id);
        return MotoristaMapper.toDTO(motorista);
    }

    @Transactional
    @Override
    public void save(MotoristaDTO motoristaDTO) {
        Motorista motorista = MotoristaMapper.toEntity(motoristaDTO);
        motoristaDAO.save(motorista);
    }

    @Transactional
    @Override
    public void delete(int id) {
        motoristaDAO.delete(id);
    }

    @Transactional
    @Override
    public List<MotoristaDTO> getMotoristasByUserId(Long userId) {
        List<Motorista> motoristas = motoristaDAO.findByUserId(userId);
        return motoristas.stream()
                         .map(MotoristaMapper::toDTO)
                         .collect(Collectors.toList());
    }
}
