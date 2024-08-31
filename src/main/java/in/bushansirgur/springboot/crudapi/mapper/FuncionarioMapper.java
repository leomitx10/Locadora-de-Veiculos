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
        dto.setUserEmail(funcionario.getUser() != null ? funcionario.getUser().getEmail() : null);
        return dto;

    }
}
