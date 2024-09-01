package com.squad2.LocadoraDeVeiculos.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fabricante;
    private String modelo;
    private String categoria;
    private String acessorios;
    private Double precoPorDia;
    private String imagem;
    private String descricao;
    private Boolean disponivel;
    private Boolean reservado = false;

}