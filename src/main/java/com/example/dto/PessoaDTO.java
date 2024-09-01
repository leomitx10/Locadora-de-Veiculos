package com.example.dto;

import java.sql.Date;

import com.example.model.Sexo;
import lombok.Data;

@Data
public class PessoaDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Sexo sexo;
   
}