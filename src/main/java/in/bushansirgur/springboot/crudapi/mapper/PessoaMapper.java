package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.PessoaDTO;
import in.bushansirgur.springboot.crudapi.model.Pessoa;

public class PessoaMapper {

    public static PessoaDTO toDTO(Pessoa pessoa) {
        if (pessoa == null) {
            return null;
        }
        PessoaDTO dto = new PessoaDTO();
        dto.setId(pessoa.getId());
        dto.setNome(pessoa.getNome());
        dto.setCpf(pessoa.getCpf());
        dto.setDataNascimento(pessoa.getDataNascimento());
        dto.setSexo(pessoa.getSexo());
        return dto;
    }

 }
