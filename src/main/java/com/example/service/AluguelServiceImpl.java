package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.AluguelDAO;
import com.example.dto.AluguelDTO;
import com.example.mapper.AluguelMapper;
import com.example.model.Aluguel;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelDAO aluguelDAO;

    @Transactional
    @Override
    public List<AluguelDTO> get() {
        return aluguelDAO.get().stream()
                .map(AluguelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AluguelDTO get(int id) {
        Aluguel aluguel = aluguelDAO.get(id);
        if (aluguel == null) {
            throw new RuntimeException("Aluguel not found for the Id:" + id);
        }
        return AluguelMapper.toDTO(aluguel);
    }

    @Transactional
    @Override
    public void save(AluguelDTO aluguelDTO) {
        Aluguel aluguel = AluguelMapper.toEntity(aluguelDTO);
        aluguelDAO.save(aluguel);
    }

    @Transactional
    @Override
    public void delete(int id) {
        aluguelDAO.delete(id);
    }

    @Transactional
    @Override
    public List<AluguelDTO> getByUserId(Long userId) {
        return aluguelDAO.getByUserId(userId).stream()
                .map(AluguelMapper::toDTO)
                .collect(Collectors.toList());
    }
}
