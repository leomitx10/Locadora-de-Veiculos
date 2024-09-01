package com.squad2.LocadoraDeVeiculos.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "modelo_carro")
public class ModeloCarro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "fabricante_id", nullable = false)
    private Fabricante fabricante;

    @OneToMany(mappedBy = "modeloCarro", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Carro> carros;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;
}