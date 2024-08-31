package com.squad2.LocadoraDeVeiculos.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "carrinho")
public class Carrinho{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "carrinho_id")
    private List<Carro> carros;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;

}