package com.squad2.LocadoraDeVeiculos.demo;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataEntrega;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;

    @Column(nullable = true)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "apolice_id", nullable = false)
    private ApoliceSeguro apolice;

    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = true)
    @JsonIgnore
    private Carrinho carrinho;

    @Override
    public String toString() {
        return "Aluguel [id=" + id + ", dataPedido=" + dataPedido + ", dataEntrega=" + dataEntrega + ", dataDevolucao="
                + dataDevolucao + ", valorTotal=" + valorTotal + ", carro=" + carro
                + ", apolice=" + apolice + "]";
    }
}