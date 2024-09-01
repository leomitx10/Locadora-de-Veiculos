package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.ApoliceDAO;
import com.example.dto.ApoliceSeguroDTO;
import com.example.mapper.ApoliceSeguroMapper;
import com.example.model.ApoliceSeguro;

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
