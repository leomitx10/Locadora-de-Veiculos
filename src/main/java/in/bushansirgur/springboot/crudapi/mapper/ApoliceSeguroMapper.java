package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.ApoliceSeguroDTO;
import in.bushansirgur.springboot.crudapi.model.ApoliceSeguro;

public class ApoliceSeguroMapper {

    public static ApoliceSeguroDTO toDTO(ApoliceSeguro apoliceSeguro) {
        if (apoliceSeguro == null) {
            return null;
        }

        ApoliceSeguroDTO dto = new ApoliceSeguroDTO();
        dto.setId(apoliceSeguro.getId());
        dto.setValorFranquia(apoliceSeguro.getValorFranquia());
        dto.setProtecaoTerceiro(apoliceSeguro.getProtecaoTerceiro());
        dto.setProtecaoCausasNaturais(apoliceSeguro.getProtecaoCausasNaturais());
        dto.setProtecaoRoubo(apoliceSeguro.getProtecaoRoubo());

        return dto;
    }

    public static ApoliceSeguro toEntity(ApoliceSeguroDTO dto) {
        if (dto == null) {
            return null;
        }

        ApoliceSeguro apoliceSeguro = new ApoliceSeguro();
        apoliceSeguro.setId(dto.getId());
        apoliceSeguro.setValorFranquia(dto.getValorFranquia());
        apoliceSeguro.setProtecaoTerceiro(dto.getProtecaoTerceiro());
        apoliceSeguro.setProtecaoCausasNaturais(dto.getProtecaoCausasNaturais());
        apoliceSeguro.setProtecaoRoubo(dto.getProtecaoRoubo());

        return apoliceSeguro;
    }
}
