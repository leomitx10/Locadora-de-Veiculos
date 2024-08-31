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
        dto.setUserEmail(motorista.getUser() != null ? motorista.getUser().getEmail() : null);

        return dto;
    }


}
