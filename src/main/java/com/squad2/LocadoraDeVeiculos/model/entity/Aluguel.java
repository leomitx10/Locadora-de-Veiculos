package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPedido;
    @Column(nullable = false)
    private LocalDate dataEntrega;
    @Column(nullable = false)
    private LocalDate dataDevolucao;
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @OneToOne
    @JoinColumn(name = "apolice_id", nullable = false)
    private ApoliceSeguro apoliceSeguro;

}
