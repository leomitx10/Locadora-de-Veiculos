package in.bushansirgur.springboot.crudapi.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AluguelDTO {

    private Integer id;
    private Date dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;
    private CarroDTO carro;
    private UserDTO user;
    private ApoliceSeguroDTO apolice;
}
