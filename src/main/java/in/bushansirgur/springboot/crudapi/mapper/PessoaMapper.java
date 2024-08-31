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

    public static Pessoa toEntity(PessoaDTO dto, Class<? extends Pessoa> pessoaClass) {
        if (dto == null) {
            return null;
        }

        try {
            Pessoa pessoa = pessoaClass.getDeclaredConstructor().newInstance();
            pessoa.setId(dto.getId());
            pessoa.setNome(dto.getNome());
            pessoa.setCpf(dto.getCpf());
            pessoa.setDataNascimento(dto.getDataNascimento());
            pessoa.setSexo(dto.getSexo());

            return pessoa;
        } catch (Exception e) {
            throw new RuntimeException("Erro instanciando Pessoa", e);
        }
    }
}
