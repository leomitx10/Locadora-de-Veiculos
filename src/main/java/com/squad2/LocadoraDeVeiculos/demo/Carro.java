package com.squad2.LocadoraDeVeiculos.demo;

import java.math.BigDecimal;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false, unique = true)
    private String chassi;

    @Column(nullable = false)
    private String cor;

    @Column(nullable = false)
    private BigDecimal valorDiaria;

    @Column(nullable = false)
    private Boolean reservado = false;

    @ManyToOne
    @JoinColumn(name = "modelo_carro_id", nullable = false)
    private ModeloCarro modeloCarro;

    @OneToMany
    @JoinColumn(name = "acessorio_id",nullable = true)
    private List<Acessorio> acessorios;

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", chassi='" + chassi + '\'' +
                ", cor='" + cor + '\'' +
                ", valorDiaria=" + valorDiaria +
                ", modeloCarro=" + modeloCarro.getDescricao() +
                ", acessorios=" + acessorios +
                '}';
    }
}