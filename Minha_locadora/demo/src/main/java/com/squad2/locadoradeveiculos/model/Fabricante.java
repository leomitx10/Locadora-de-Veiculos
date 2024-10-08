package com.squad2.locadoradeveiculos.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "Fabricante")

public class Fabricante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModeloCarro(List<ModeloCarro> modeloCarro) {
        modeloCarro = modeloCarro;
    }

    @Override
    public String toString() {
        return "Fabricante{" +
                "id=" + id +
                ", nome='" + nome  +
                '}';
    }
}
