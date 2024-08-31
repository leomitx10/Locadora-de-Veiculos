package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.FuncionarioDAO;
import in.bushansirgur.springboot.crudapi.dto.FuncionarioDTO;
import in.bushansirgur.springboot.crudapi.mapper.FuncionarioMapper;
import in.bushansirgur.springboot.crudapi.model.Funcionario;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioDAO funcionarioDAO;

    @Transactional
    @Override
    public List<FuncionarioDTO> get() {
        return funcionarioDAO.get().stream()
                .map(FuncionarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public FuncionarioDTO get(int id) {
        Funcionario funcionario = funcionarioDAO.get(id);
        if (funcionario == null) {
            throw new RuntimeException("Employee not found for the Id:" + id);
        }
        return FuncionarioMapper.toDTO(funcionario);
    }

    @Transactional
    @Override
    public FuncionarioDTO save(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = FuncionarioMapper.toEntity(funcionarioDTO);
        funcionario = funcionarioDAO.save(funcionario);
        return FuncionarioMapper.toDTO(funcionario);
    }

    @Transactional
    @Override
    public void delete(int id) {
        funcionarioDAO.delete(id);
    }
}
