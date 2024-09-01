package com.squad2.LocadoraDeVeiculos.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@ToString(callSuper = true, exclude =  "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Motorista extends Pessoa {

    @Column(nullable = false)
    private String numeroCNH;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}