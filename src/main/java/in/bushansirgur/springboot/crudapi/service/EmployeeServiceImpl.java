package in.bushansirgur.springboot.crudapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dao.EmployeeDAO;
import in.bushansirgur.springboot.crudapi.dto.FuncionarioDTO;
import in.bushansirgur.springboot.crudapi.dto.MotoristaDTO;
import in.bushansirgur.springboot.crudapi.dto.PessoaDTO;
import in.bushansirgur.springboot.crudapi.mapper.PessoaMapper;
import in.bushansirgur.springboot.crudapi.model.Funcionario;
import in.bushansirgur.springboot.crudapi.model.Motorista;
import in.bushansirgur.springboot.crudapi.model.Pessoa;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO; 
    
    @Transactional
    @Override
    public List<PessoaDTO> getAll() {
        List<Pessoa> pessoas = employeeDAO.getAll();
        return pessoas.stream()
                      .map(PessoaMapper::toDTO)
                      .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public PessoaDTO get(int id) {
        Pessoa pessoa = employeeDAO.get(id);
        return PessoaMapper.toDTO(pessoa);
    }

    @Transactional
    @Override
    public void save(PessoaDTO pessoaDTO) {
        Class<? extends Pessoa> pessoaClass = getPessoaClass(pessoaDTO);
        Pessoa pessoa = PessoaMapper.toEntity(pessoaDTO, pessoaClass);
        employeeDAO.save(pessoa);
    }

    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

     private Class<? extends Pessoa> getPessoaClass(PessoaDTO pessoaDTO) {
        if (pessoaDTO instanceof FuncionarioDTO) {
            return Funcionario.class;
        } else if (pessoaDTO instanceof MotoristaDTO) {
            return Motorista.class;
        } else {
            throw new IllegalArgumentException("Unknown DTO type: " + pessoaDTO.getClass().getName());
        }
    }
}
