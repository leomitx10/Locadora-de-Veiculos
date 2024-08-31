package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.FuncionarioDTO;
import in.bushansirgur.springboot.crudapi.model.Funcionario;

public class FuncionarioMapper {
    public static FuncionarioDTO toDTO(Funcionario funcionario) {
        if (funcionario == null) {
            return null;
        }
    
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setCpf(funcionario.getCpf());
        dto.setDataNascimento(funcionario.getDataNascimento());
        dto.setSexo(funcionario.getSexo());
        dto.setMatricula(funcionario.getMatricula());
        return dto;
    }

    public static Funcionario toEntity(FuncionarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setDataNascimento(dto.getDataNascimento());
        funcionario.setSexo(dto.getSexo());
        funcionario.setMatricula(dto.getMatricula());
    
        return funcionario;
    }
}
