package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.ApoliceDAO;
import in.bushansirgur.springboot.crudapi.dto.ApoliceSeguroDTO;
import in.bushansirgur.springboot.crudapi.mapper.ApoliceSeguroMapper;
import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;

@Service
public class ApoliceServiceImpl implements ApoliceService {

    @Autowired
    private ApoliceDAO apoliceDAO;

    @Transactional
    @Override
    public List<ApoliceSeguroDTO> get() {
        List<ApoliceSeguro> apolice = apoliceDAO.get(); 
        return apolice.stream()
                      .map(ApoliceSeguroMapper::toDTO)
                      .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ApoliceSeguroDTO get(int id) { 
        ApoliceSeguro apolice = apoliceDAO.get(id);
        return ApoliceSeguroMapper.toDTO(apolice); 
    }

    @Transactional
    @Override
    public void save(ApoliceSeguroDTO apoliceDTO) { 
        ApoliceSeguro apolice = ApoliceSeguroMapper.toEntity(apoliceDTO);
        apoliceDAO.save(apolice);
    }

    @Transactional
    @Override
    public void delete(int id) {
        apoliceDAO.delete(id);
    }
}
