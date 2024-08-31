package in.bushansirgur.springboot.crudapi.mapper;

import in.bushansirgur.springboot.crudapi.dto.AluguelDTO;
import in.bushansirgur.springboot.crudapi.model.Aluguel;

public class AluguelMapper {

    public static AluguelDTO toDTO(Aluguel aluguel) {
        if (aluguel == null) {
            return null;
        }
        
        AluguelDTO dto = new AluguelDTO();
        dto.setId(aluguel.getId());
        dto.setDataPedido(aluguel.getDataPedido());
        dto.setDataEntrega(aluguel.getDataEntrega());
        dto.setDataDevolucao(aluguel.getDataDevolucao());
        dto.setValorTotal(aluguel.getValorTotal());
        dto.setCarro(CarroMapper.toDTO(aluguel.getCarro()));
        dto.setUser(UserMapper.toDTO(aluguel.getUser()));
        dto.setApolice(ApoliceSeguroMapper.toDTO(aluguel.getApolice()));
        
        return dto;
    }

    public static Aluguel toEntity(AluguelDTO dto) {
        if (dto == null) {
            return null;
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setId(dto.getId());
        aluguel.setDataPedido(dto.getDataPedido());
        aluguel.setDataEntrega(dto.getDataEntrega());
        aluguel.setDataDevolucao(dto.getDataDevolucao());
        aluguel.setValorTotal(dto.getValorTotal());
        aluguel.setCarro(CarroMapper.toEntity(dto.getCarro()));
        aluguel.setUser(UserMapper.toEntity(dto.getUser()));
        aluguel.setApolice(ApoliceSeguroMapper.toEntity(dto.getApolice()));
        
        return aluguel;
    }
}
