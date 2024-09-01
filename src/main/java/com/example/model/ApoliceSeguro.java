package com.example.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
