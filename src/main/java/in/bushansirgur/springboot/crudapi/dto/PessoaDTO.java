package in.bushansirgur.springboot.crudapi.dto;

import java.sql.Date;

import in.bushansirgur.springboot.crudapi.model.Sexo;
import lombok.Data;

@Data
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Sexo sexo;
   
}