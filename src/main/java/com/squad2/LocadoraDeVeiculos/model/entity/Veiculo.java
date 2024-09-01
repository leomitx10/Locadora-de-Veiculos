package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@ToString
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fabricante;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private String categoria;

    @Column(length = 500)
    private String acessorios;

    @Column(nullable = false)
    private Double precoPorDia;

    @Column(length = 255)
    private String imagem;

    @Column(length = 1000)
    private String descricao;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false)
    private Boolean reservado = false;
}
