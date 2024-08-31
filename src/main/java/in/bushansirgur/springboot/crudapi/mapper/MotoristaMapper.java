package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.MotoristaDTO;
import in.bushansirgur.springboot.crudapi.model.Motorista;


public class MotoristaMapper {

    public static MotoristaDTO toDTO(Motorista motorista) {
        if (motorista == null) {
            return null;
        }
        
        MotoristaDTO dto = new MotoristaDTO();
        dto.setId(motorista.getId());
        dto.setNome(motorista.getNome());
        dto.setCpf(motorista.getCpf());
        dto.setDataNascimento(motorista.getDataNascimento());
        dto.setSexo(motorista.getSexo());
        dto.setNumeroCNH(motorista.getNumeroCNH());

        return dto;
    }

    public static Motorista toEntity(MotoristaDTO dto) {
        if (dto == null) {
            return null;
        }

        Motorista motorista = new Motorista();
        motorista.setId(dto.getId());
        motorista.setNome(dto.getNome());
        motorista.setCpf(dto.getCpf());
        motorista.setDataNascimento(dto.getDataNascimento());
        motorista.setSexo(dto.getSexo());
        motorista.setNumeroCNH(dto.getNumeroCNH());
        return motorista;
    }


}
