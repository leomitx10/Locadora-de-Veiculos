package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id", nullable = false)
    private ModeloCarro modeloCarro;

    @OneToMany
    @JoinColumn(name = "carro_id")
    private List<Acessorio> acessorios;

}