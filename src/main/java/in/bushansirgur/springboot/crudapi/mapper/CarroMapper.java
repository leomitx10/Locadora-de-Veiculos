package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.CarroDTO;
import in.bushansirgur.springboot.crudapi.model.Carro;

public class CarroMapper {

    public static CarroDTO toDTO(Carro carro) {
        if (carro == null) {
            return null;
        }
        
        CarroDTO dto = new CarroDTO();
        dto.setId(carro.getId());
        dto.setPlaca(carro.getPlaca());
        dto.setChassi(carro.getChassi());
        dto.setCor(carro.getCor());
        dto.setValorDiaria(carro.getValorDiaria());

        return dto;
    }

    public static Carro toEntity(CarroDTO dto) {
        if (dto == null) {
            return null;
        }

        Carro carro = new Carro();
        carro.setId(dto.getId());
        carro.setPlaca(dto.getPlaca());
        carro.setChassi(dto.getChassi());
        carro.setCor(dto.getCor());
        carro.setValorDiaria(dto.getValorDiaria());

        return carro;
    }
}
