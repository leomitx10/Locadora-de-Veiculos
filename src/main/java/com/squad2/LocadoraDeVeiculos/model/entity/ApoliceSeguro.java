package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apolice")
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valorFranquia;
    @Column(nullable = false)
    private Boolean protecaoTerceiro;
    @Column(nullable = false)
    private Boolean protecaoCausasNaturais;
    @Column(nullable = false)
    private Boolean protecaoRoubo;

}
