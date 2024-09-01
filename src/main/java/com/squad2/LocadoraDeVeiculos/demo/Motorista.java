package com.squad2.LocadoraDeVeiculos.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Motorista extends Pessoa {

    @Column(nullable = false, unique = true)
    private String numeroCNH;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;


    @Override
    public String toString() {
        return "Motorista [numeroCNH=" + numeroCNH + ", usuario=" + usuario.getEmail() + "]";
    }
}
