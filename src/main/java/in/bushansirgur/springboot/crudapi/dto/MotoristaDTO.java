package in.bushansirgur.springboot.crudapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotoristaDTO extends PessoaDTO {

    private String numeroCNH;
    private String userEmail;
}
