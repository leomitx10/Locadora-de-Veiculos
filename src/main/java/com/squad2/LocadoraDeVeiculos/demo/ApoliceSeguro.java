package com.squad2.LocadoraDeVeiculos.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "apolice_seguro")
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_franquia", nullable = false)
    private BigDecimal valorFranquia;

    @Column(name = "protecao_terceiro", nullable = false)
    private Boolean protecaoTerceiro;

    @Column(name = "protecao_causas_naturais", nullable = false)
    private Boolean protecaoCausasNaturais;

    @Column(name = "protecao_roubo", nullable = false)
    private Boolean protecaoRoubo;

}