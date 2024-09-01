package com.example.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO extends PessoaDTO{

    private String matricula;
    private UserDTO user;
}
